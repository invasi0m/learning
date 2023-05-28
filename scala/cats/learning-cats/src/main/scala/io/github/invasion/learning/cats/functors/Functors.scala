package io.github.invasion.learning.cats.functors

import scala.util.Try

object Functors extends App {

  val unaListaModificada = List(1, 2, 3).map(_ + 1) // List(2,3,4)
  println(unaListaModificada)

  val unOptionModificado = Option(2).map(_ + 1) //Some(3)
  println(unOptionModificado)

  val unTryModificad = Try(33).map(_ + 1) // Success(34)
  println(unTryModificad)

  // definición simplificada
  trait MyFunctor[F[_]] {
    def map[A, B](valorInicial: F[A])(f: A => B): F[B]
  }

  import cats.Functor
  import cats.instances.list._

  val listFunctor = Functor[List]
  val incrementarNumeros = listFunctor.map(List(1, 2, 3))(_ + 1)
  println(incrementarNumeros)

  import cats.instances.option._

  val optFunctor = Functor[Option]
  val incrementarOption = optFunctor.map(Option(2))(_ + 1)
  println(incrementarOption)

  import cats.instances.try_

  val incrementarTry = Functor[Try].map(Try(33))(_ + 1)

  println(incrementarTry)

  // tenemos muchos contenerdores y tendríamos que hacer para todos
  def por10List(list: List[Int]): List[Int] = list.map(_ * 10)
  def por10Opt(opt: Option[Int]): Option[Int] = opt.map(_ * 10)
  def por10Try(intento: Try[Int]): Try[Int] = intento.map(_ * 10)

  // Generalizaremos
  def por10[F[_]](container: F[Int])(implicit functor: Functor[F]): F[Int] = functor.map(container)(_ * 10)

  println(por10(List(1, 2, 3))(Functor[List]))
  println(por10(List(1, 2, 3)))
  println(por10(Option(1)))
}
