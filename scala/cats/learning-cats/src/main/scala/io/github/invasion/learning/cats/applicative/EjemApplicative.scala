package io.github.invasion.learning.cats.applicative


import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

object EjemApplicative extends App {


  import cats.Applicative
  //  import cats.instances.option._
  import cats.instances.future._
  import cats.syntax.all._
  //  import cats.implicits._

  case class UnaClase(name: String, value: Int, otro: Int)

  //  println((Option("David"), Option(1), Option(2)).mapN(Trato))
  //  println((Option("David"), Option(1), None).mapN(Trato))


  def getName: Future[String] = Future {
    Thread.sleep(3000)
    println("111")
    "david"
  }

  def getValue: Future[Int] = Future {
    Thread.sleep(5000)
    println("222")
    1
  }

  def getOtro: Future[Int] = Future {
    Thread.sleep(1000)
    println("333")
    2
  }

  val res: Future[UnaClase] = (getName, getValue, getOtro).mapN(UnaClase)
  println(Await.result(res, 8 seconds))
}
