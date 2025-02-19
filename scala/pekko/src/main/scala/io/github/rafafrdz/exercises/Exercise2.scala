package io.github.rafafrdz.exercises

import cats.effect.{IO, IOApp}
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.{ActorContext, Behaviors}

object Exercise2 extends IOApp.Simple {

  sealed trait SimpleThings

  case object EatChocolate extends SimpleThings

  case object CleanUpTheFloor extends SimpleThings

  case object LearnAkka extends SimpleThings


  def tasksActors: Behavior[SimpleThings] =
    Behaviors.setup {
      context =>
        context.setLoggerName("[Home Chores]")
        tasks(0)(context)
    }

  def tasks(happiness: Int)(implicit context: ActorContext[SimpleThings]): Behavior[SimpleThings] =
    Behaviors.receiveMessage {
      case EatChocolate if happiness == 3 =>
        context.log.error(s"[Happiness: $happiness] I don't wanna more chocolate please..")
        tasks(happiness)
      case EatChocolate =>
        context.log.info(s"[Happiness: $happiness] Here we goo! more chocolate!")
        tasks(happiness + 1)
      case CleanUpTheFloor if happiness < 1 =>
        context.log.error(s"[Happiness: $happiness] I need some chocolate to start cleaning up the floor...")
        tasks(happiness)
      case CleanUpTheFloor =>
        context.log.info(s"[Happiness: $happiness] The floor is cleaned up. I'm so tired!")
        tasks(0)
      case LearnAkka if happiness == 0 =>
        context.log.info(s"[Happiness: $happiness] I would like but I need some chocolate...")
        tasks(happiness)
      case LearnAkka =>
        context.log.info(s"[Happiness: $happiness] Always is a good moment to continue learning akka!")
        tasks(happiness - 1)
    }

  val choresList: Vector[SimpleThings] =
    Vector(
      EatChocolate,
      CleanUpTheFloor,
      CleanUpTheFloor,
      CleanUpTheFloor,
      EatChocolate,
      EatChocolate,
      EatChocolate,
      EatChocolate,
      EatChocolate,
      CleanUpTheFloor,
      LearnAkka,
      EatChocolate,
      EatChocolate,
      LearnAkka
    )

  override def run: IO[Unit] =
    actorSystem[IO, SimpleThings](tasksActors, "home-chores-app")
      .use { actors =>
        IO.delay {
          choresList foreach {
            mssg =>
              actors ! mssg
          }
        }

      }
}
