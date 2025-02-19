package io.github.rafafrdz.exercises

import cats.effect.{IO, IOApp}
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.actor.typed.{ActorRef, Behavior}

object ChildExercise extends IOApp.Simple {

  sealed trait Command
  case class CreateChild(name: String)             extends Command
  case class TellChild(name: String, mssg: String) extends Command

  val cmd: Vector[Command] =
    Vector(
      CreateChild("child-1"),
      TellChild("child-1", "this is a secret"),
      CreateChild("child-2"),
      CreateChild("child-3"),
      TellChild("child-2", "don't tell anybody anything"),
      CreateChild("child-3"),
      TellChild("child-3", "I like it"),
      TellChild("child-99", "I like it"),
      TellChild("child-1", "What is happening?")
    )

  def system: Behavior[Unit] = Behaviors.setup { context =>
    /** Set up all the important actors in your application */
    val sys: ActorRef[Command] = context.spawn(active(Map.empty), "parent-guardian")
    cmd foreach { c =>
      sys ! c
    }

    Behaviors.empty
  }

  def active(refs: Map[String, ActorRef[String]]): Behavior[Command] = Behaviors.receive {
    (context, message) =>
      context.setLoggerName("[Parent]")
      message match {
        case CreateChild(name) if !refs.contains(name) =>
          context.log.info(s"Creating child with name: '$name'")
          val child: ActorRef[String] = context.spawn(childB(name), name)
          active(refs + (name -> child))
        case CreateChild(name) =>
          context.log.warn(s"child with name: '$name' already exists")
          Behaviors.same
        case TellChild(name, mssg) =>
          context.log.info(s"Telling to child '$name' something...")
          val childOpt: Option[ActorRef[String]] = refs.get(name)
          childOpt
            .fold(context.log.error(s"Child '$name' couldn't be found!"))(child => child ! mssg)
          Behaviors.same
      }

  }

  def childB(name: String): Behavior[String] = Behaviors.receive { (context, message) =>
    context.setLoggerName(s"[Child $name]")
    context.log.info(s"Received message! '$message'")
    Behaviors.same
  }

  override def run: IO[Unit] =
    actorSystem[IO, Unit](system, "parent-child-app").use(_ => IO.never[Unit])
}
