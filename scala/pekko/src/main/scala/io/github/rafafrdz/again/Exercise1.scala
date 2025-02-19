package io.github.rafafrdz.again

import org.apache.pekko.actor.typed.{ActorSystem, Behavior}
import org.apache.pekko.actor.typed.scaladsl.Behaviors

object Exercise1 {

  object PersonActor {
    def happy: Behavior[String] = Behaviors.receive { (context, message) =>
      context.log.info(s"[😂] I've received this message: '$message'. That's great!")
      if(message.contains("mal")) sad else Behaviors.same
    }

    def sad: Behavior[String] = Behaviors.receive { (context, message) =>
      context.log.info(s"[😭] I've received this message: '$message'. That sucks!")
      if(message.contains("pepino")) happy else Behaviors.same
    }
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem(PersonActor.happy, "happy-actor-system")

    system ! "Hola caracola"
    system ! "Tengo una mala noticia. Me vino la regla"
    system ! "Pero no me importa.. Porque tengo a pepino! (guau guau)"
    system ! "Aaaaay!!!!"

    system.terminate()
  }

}
