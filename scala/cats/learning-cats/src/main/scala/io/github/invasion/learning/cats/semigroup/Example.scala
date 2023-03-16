package io.github.invasion.learning.cats.semigroup

import cats.Semigroup
import cats.implicits._
import io.github.invasion.learning.cats.semigroup.SemigroupC.factsSemigrupo3
import io.github.invasion.learning.cats.semigroup.SemigroupL.Factura

object Example {

  /**
   * Crea una operacion generica para reducir una coleccion de almenos dos elementos
   * de un tipo cualquiera
   */

  /** Semigroup[T] => List[T] -> T */
  def reduce[T](xs: List[T])(implicit sem: Semigroup[T]): T = xs.reduce(_ combine _)
  //    xs.reduce((a,b) => sem.combine(a, b))

  def reduceAlt[T: Semigroup](xs: List[T]): T = xs.reduce(_ combine _)

  def reduceAlt2[T: SemigroupT](xs: List[T]): T = xs.reduce(implicitly[SemigroupT[T]].combine)


  def main(args: Array[String]): Unit = {
    val f1: Factura = Factura(0, "compraA", 10)
    val f2: Factura = Factura(1, "compraB", 7)
    reduceAlt(List(f1, f2))
    reduceAlt2(List(1, 2, 3))
    reduceAlt2(List(f1, f2))
  }

}
