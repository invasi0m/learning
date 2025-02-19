package io.github.rafafrdz

import cats.Applicative
import cats.effect.kernel.Resource
import cats.implicits._
import org.apache.pekko.actor.typed.{ActorSystem, Behavior}

package object exercises {

  def actorSystem[F[_] : Applicative, T](guardianBehavior: Behavior[T], name: String): Resource[F, ActorSystem[T]] =
    Resource.make(ActorSystem(guardianBehavior, name).pure[F])(system => system.terminate().pure[F])

}
