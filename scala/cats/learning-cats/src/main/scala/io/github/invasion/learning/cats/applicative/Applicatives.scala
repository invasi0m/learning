package io.github.invasion.learning.cats.applicative


object Applicatives extends App {

  // Applicativo = Functor + pure

  import cats.Applicative
  import cats.instances.list._

  val listApplicative = Applicative[List]
  val unaList = listApplicative.pure(2) // List(2)

  import cats.instances.option._

  val optApplicative = Applicative[Option]
  val unOption: Option[Int] = optApplicative.pure(2) //Some(2)

  def suma(a: Int): Int = a + 10

  println(unOption.map(suma(_)))

  import cats.syntax.applicative._

  val unaDulceLista = 2.pure[List]
  val unDulceOption = 2.pure[Option]

}
