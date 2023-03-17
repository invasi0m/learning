package io.github.invasion.learning.cats.monoid

import cats.Monoid

object Example {

  /**
   * Implementa una operacion generica para reducir una coleccion de de un tipo cualquiera.
   * Define ejemplos en el main para ver que funciona correctamente.
   *
   * Nota: Aqui la diferencia con el ejercicio de los semigrupos es que no estamos restringiendo
   * el minimo de elementos que debe tener la coleccion.
   *
   * Consejo: Aquí puedes sustituir el tipo What por el tipo que creas correcto o usar el tipo
   * What como alias para ese tipo.
   */
  //
  //  type What = List[Int]
  //
  implicit val monoidInt: Monoid[Int] = new Monoid[Int] {
    override def empty: Int = 0

    override def combine(x: Int, y: Int): Int = x + y
  }

  def reduce[T](xs: List[T])(implicit w: Monoid[T]): T = xs.foldLeft(w.empty)((acc, c) => w.combine(acc, c))

  //  def reduceAlt[T: What](xs: List[T]): T = ???

  def reduceAlt[T: Monoid](xs: List[T]): T = xs.foldLeft(implicitly[Monoid[T]].empty)((acc, c) => implicitly[Monoid[T]].combine(acc, c))


  def main(args: Array[String]): Unit = {
    println(reduce(List()))
    println(reduce(List(1, 2, 3)))
    println(reduceAlt(List()))
    println(reduceAlt(List(1, 2, 3)))
  }

}
