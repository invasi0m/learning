package io.github.invasion.learning.cats.applicative

import cats.{Applicative, Apply}

object Applys extends App {

  import cats.implicits._

  val intToString: Int => String = _.toString
  val double: Int => Int = _ * 2
  val addTwo: Int => Int = _ + 2
  val addTwo2 = (a: Int, b: Int, c: Int) => a + b + c + 2
  val addTwo3 = (a: Int, b: Int, c: Int) => (a + b, c + 2)

  println(Apply[Option].map(Some(1))(double))
  println(Applicative[Option].pure(1).map(double))
  println(Applicative[Option].pure(1).map(double))

  type Map1[X] = Map[String, X]
  val aa = new Applicative[Map1] {
    //    override def pure[A](x: A): Map1[A] = Map(""->x)
    override def pure[A](x: A): Map1[A] = Map("a" -> x)

    override def ap[A, B](ff: Map1[A => B])(fa: Map1[A]): Map1[B] = ???
  }

  val opt1: Option[Int] = Applicative[Option].map3(Applicative[Option].pure(1), Applicative[Option].pure(2), Applicative[Option].pure(3))(addTwo2)
  val opt2: Option[(Int, Int)] = Applicative[Option].map3(Applicative[Option].pure(1), Applicative[Option].pure(2), Applicative[Option].pure(3))(addTwo3)

  type D[X] = X

  val dd = new Applicative[D] {
    override def pure[A](x: A): D[A] = ???

    override def ap[A, B](ff: D[A => B])(fa: D[A]): D[B] = ???

    def map[A, B](f: A => B)(fa: D[A]): D[B] = ap(pure(f))(fa) /*D[A=>B]*/
  }
}
