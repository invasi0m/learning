package io.github.invasion.learning.cats.semigroup

import cats._
import cats.implicits._
import io.github.invasion.learning.cats.semigroup.SemigroupL.{+/\+, +:+, Factura}

object SemigroupC {

  val numSemigroup: Semigroup[Int] = _ + _

  val listSemigroup: Semigroup[List[Int]] = _ ::: _


  val factSemigroup: Semigroup[Factura] = _ +:+ _

  /** esto lo podemos hacer porque tenemos la clase implicita
   * sino, habria que hacer lo siguiente: */
  val factAltSemigroup: Semigroup[Factura] = +:+

  /** Sin embargo no podemos hacer lo siguiente:
   *
   * Semigroup[Factura] // No implicits found for parameter ev: Semigroup[Factura]
   *
   * Esto quiere decir que en el core de cats no encuentra un implicito o una forma de derivar
   * el implicito del Semigrupo de Factura, por ello es que tenemos que definirlo explictamente
   * */

  val factsSemigrupo2: Semigroup[Factura] = _ +/\+ _
  val factsAltSemigrupo2: Semigroup[Factura] = +/\+

  // aqui f1 combine f2 no funciona
  implicit val factsSemigrupo3: Semigroup[Factura] = (x: Factura, y: Factura) =>
    Factura(
      x.uuid.combine(y.uuid),
      x.concepto combine y.concepto,
      x.cantidad combine y.cantidad
    )

  // aqui f1 combine f2 si funciona

  def main(args: Array[String]): Unit = {
    val f1: Factura = Factura(0, "compraA", 10)
    val f2: Factura = Factura(1, "compraB", 7)


    f1 combine f2

    List(
      numSemigroup.combine(3, 5),
      Semigroup[Int].combine(3, 5),
      listSemigroup.combine(List(1, 2, 3), List(4, 5, 6)),
      Semigroup[List[Int]].combine(List(1, 2, 3), List(4, 5, 6)),
      factSemigroup.combine(f1, f2),
      factsSemigrupo2.combine(f1, f2),
      factsSemigrupo3.combine(f1, f2)
    ) foreach println
  }
}
