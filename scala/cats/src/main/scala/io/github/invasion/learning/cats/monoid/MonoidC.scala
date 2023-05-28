package io.github.invasion.learning.cats.monoid

import cats._
import cats.implicits._
import io.github.invasion.learning.cats.monoid.MonoidL.{Folio, FolioRelleno, FolioVacio}

object MonoidC {

  val numMonoid: Monoid[Int] = Monoid[Int]

  val listMonoid: Monoid[List[Int]] = Monoid[List[Int]]

  implicit val foliosMonoid: Monoid[Folio] = new Monoid[Folio] {
    override def empty: Folio = FolioVacio

    override def combine(x: Folio, y: Folio): Folio = x -*- y
  }

  def main(args: Array[String]): Unit = {
    val f1: Folio = FolioRelleno("cosas")
    val f2: Folio = FolioRelleno("y más cosas")

    val f3 = foliosMonoid.combine(foliosMonoid.combine(f1, f2), foliosMonoid.empty)
    val f3Alt = foliosMonoid.combine(foliosMonoid.empty, foliosMonoid.combine(f1, f2))
    val propiedadAsociativa: Boolean = f3 == f3Alt

    List(
      numMonoid.combine(numMonoid.combine(3, 4), numMonoid.empty),
      3 combine 4 combine numMonoid.empty,
      listMonoid.combine(listMonoid.combine(List(1, 2, 3), List(4, 5, 6)), listMonoid.empty),
      List(1, 2, 3) combine List(4, 5, 6) combine Nil,
      f1 combine f2 combine FolioVacio,
      f3,
      f3Alt,
      propiedadAsociativa
    ) foreach println
  }
}
