package io.github.invasion.learning.cats.monoid

import io.github.invasion.learning.cats.semigroup.SemigroupL.{Semigroup, main}

object MonoidL {

  trait Monoid[A] extends Semigroup[A] {
    def empty: A
  }

  /** Ejemplos */

  /** El conjunto de los numeros reales con la operacion suma forman un monoide */
  val numerosMonoide: Monoid[Int] = new Monoid[Int] {
    override def empty: Int = 0

    override def combine(x: Int, y: Int): Int = x + y
  }

  val listasMonoide: Monoid[List[Int]] = new Monoid[List[Int]] {
    override def empty: List[Int] = Nil

    override def combine(x: List[Int], y: List[Int]): List[Int] = x ::: y
  }

  val stringsMonoide: Monoid[String] = new Monoid[String] {
    override def empty: String = ""

    override def combine(x: String, y: String): String = x ++ y
  }

  sealed trait Folio

  case class FolioRelleno(contenido: String) extends Folio

  case object FolioVacio extends Folio

  /**
   * Análogo al semigrupo, no existe una definición formal o matemática del Monoide de un folio.
   * Sin embargo, queremos definir nuestro propio monoide de folios. Esto es, según nuestro contexto,
   * tiene sentido que, por ejemplo:
   *
   * El Monoide de los folios sera:
   * - El conjunto de los folios junto a
   * - La operación -*- que para dos folios f1 y f2, se genere un nuevo folio f3 cuyo
   * contenido es la concatenación de los contenidos de ambos folios con un espacio entre ellos.
   * - El elemento identidad de nuestro monoide de folios va a ser el FolioVacio.
   */

  def -*-(f1: Folio, f2: Folio): Folio =
    (f1, f2) match {
      case (FolioRelleno(c1), FolioRelleno(c2)) => FolioRelleno(c1 ++ " " ++ c2)
      case (FolioVacio, f) => f
      case (f, FolioVacio) => f
    }

  implicit class ImplicitFolio(f1: Folio) {
    def -*-(f2: Folio): Folio = MonoidL.-*-(f1, f2)
  }

  val foliosMonoide: Monoid[Folio] = new Monoid[Folio] {
    override def empty: Folio = FolioVacio

    override def combine(x: Folio, y: Folio): Folio = x -*- y
  }

  def main(args: Array[String]): Unit = {
    val f1: Folio = FolioRelleno("cosas")
    val f2: Folio = FolioRelleno("y más cosas")

    val f3 = foliosMonoide.combine(foliosMonoide.combine(f1, f2), foliosMonoide.empty)
    val f3Alt = foliosMonoide.combine(foliosMonoide.empty, foliosMonoide.combine(f1, f2))
    val propiedadAsociativa: Boolean = f3 == f3Alt

    List(
      numerosMonoide.combine(numerosMonoide.combine(3, 4), numerosMonoide.empty),
      listasMonoide.combine(listasMonoide.combine(List(1,2,3), List(4, 5, 6)), listasMonoide.empty),
      f3,
      f3Alt,
      propiedadAsociativa
    ) foreach println
  }
}