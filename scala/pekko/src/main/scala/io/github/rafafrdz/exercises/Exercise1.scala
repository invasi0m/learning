package io.github.rafafrdz.exercises

import cats.effect.{IO, IOApp}
import org.apache.pekko.actor.typed.scaladsl.{ActorContext, Behaviors}
import org.apache.pekko.actor.typed.{ActorSystem, Behavior}

import scala.concurrent.duration._

/**
 * ActorState exercise
 * Use the setup method to create a word counter which:
 *  - splits each message into words
 *  - Keeps track of the TOTAL number of words received so far
 *  - log the current # of words + TOTAL # of words
 */
object Exercise1 extends IOApp.Simple {

  def actors: Behavior[String] = Behaviors.setup {
    context =>
      context.setLoggerName("[Counter Actor]")
      counterActor(0, context)
  }

  def counterActor(totalWords: Int, context: ActorContext[String]):
  Behavior[String] = Behaviors.receiveMessage {
    message =>
      val words: Array[String] = message.split(" ")
      val wordsCount: Int = words.length
      val newTotalCount: Int = totalWords + wordsCount
      context.log.info(s"current words: $wordsCount. total words: $newTotalCount")
      counterActor(newTotalCount, context)
  }

  val mssgs: Vector[String] =
    Vector(
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
      "Where does it come from?",
      "It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.",
      "all right!"
    )

  /** scala-regular style */
  def regular(args: Array[String]): Unit = {
    val actorSystem: ActorSystem[String] = ActorSystem(actors, "counter-app")

    mssgs foreach {
      mssg => actorSystem ! mssg
    }

    Thread.sleep(1000)
    actorSystem.terminate()
  }

  /** Resource-cats-effect style */
  override def run: IO[Unit] =
    actorSystem[IO, String](actors, "counter-app").use {
      system =>
        mssgs foreach {
          mssg => system ! mssg
        }

        IO.sleep(1.second)
    }
}
