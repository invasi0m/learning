package io.github.rafafrdz.again

import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.actor.typed.{ActorSystem, Behavior}

object Exercise2 {

  object WordsActor {
    def init: Behavior[String] = Behaviors.setup { context =>
      context.log.info("Initiating WordCounter Actor")
      counter(0)
    }

    def counter(acc: Int): Behavior[String] =
      Behaviors.receive { (context, message) =>
        val words: Array[String] = message.split(" ")
        val count: Int           = words.length
        val total: Int           = acc + count
        context.log.info(s"The message '$message' has $count words. In total: $total")
        counter(total)
      }
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem(WordsActor.init, "word-counter-actor-system")

    system ! "Hola caracola"
    system ! "Tengo una mala noticia. Me vino la regla"
    system ! "Pero no me importa.. Porque tengo a pepino! (guau guau)"
    system ! "Aaaaay!!!!"

    system.terminate()
  }

}
