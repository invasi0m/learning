package io.github.invasion.learning.cats.monoid

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

  type What[T]

  def reduce[T](xs: List[T])(implicit w: What[T]): T = ???

  def reduceAlt[T: What](xs: List[T]): T = ???



  def main(args: Array[String]): Unit = {
    ???
  }

}
