package io.github.invasion.learning.cats.semigroup

import io.github.invasion.learning.cats.semigroup.SemigroupL.Factura

trait SemigroupT[A] {
  def combine(x: A, y: A): A
}

object SemigroupT {

  implicit val numerosSemigrupo: SemigroupT[Int] = _ + _

  implicit val listasSemigrupo: SemigroupT[List[Int]] = (x: List[Int], y: List[Int]) => x ::: y

  implicit val stringsSemigrupo: SemigroupT[String] = new SemigroupT[String] {
    override def combine(x: String, y: String): String = x ++ y
  }

  implicit val facturaSemigrupo3: SemigroupT[Factura] = new SemigroupT[Factura] {
    override def combine(x: Factura, y: Factura): Factura =
      Factura(numerosSemigrupo.combine(x.uuid, y.uuid), stringsSemigrupo.combine(x.concepto, y.concepto), numerosSemigrupo.combine(x.cantidad, y.cantidad))
  }

}
