package io.github.invasion.learning.cats.monoid

import cats.Monoid
import io.github.invasion.learning.cats.monoid.Example.reduce
import io.github.invasion.learning.cats.monoid.MonoidL.{Folio, FolioRelleno, FolioVacio}
import org.scalatest.flatspec.AnyFlatSpec

import org.scalatest.matchers.should.Matchers

class FoliosMonoidTest extends AnyFlatSpec with Matchers {
  "Folio" should "reduce correctamente" in {
    val f0: Folio = FolioVacio
    val f1: Folio = FolioRelleno("cosas")
    val f2: Folio = FolioRelleno("y más cosas")
    implicit val foliosMonoid: Monoid[Folio] = new Monoid[Folio] {
      override def empty: Folio = FolioVacio

      override def combine(x: Folio, y: Folio): Folio = x -*- y
    }

    reduce(List(f0, f1, f2)) shouldBe FolioRelleno("cosas y más cosas")
  }
}
