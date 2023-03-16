package io.github.invasion.learning.cats.semigroup

object SemigroupL {

  trait Semigroup[A] {
    def combine(x: A, y: A): A
  }

  /** Ejemplos */

  /** El conjunto de los numeros reales con la operacion suma forman un semigrupo (de hecho forman un monoide) */
  val numerosSemigrupo: Semigroup[Int] = _ + _


  /** El conjunto de las listas de enteros con la operación concatenación forma un semigrupo (de hecho forman un monoide) */
  val listasSemigrupo: Semigroup[List[Int]] = (x: List[Int], y: List[Int]) => x ::: y

  /** El conjunto de las cadenas de caracteres o Strings con la operación concatenación forma un semigrupo (de hecho forman un monoide) */
  val stringsSemigrupo: Semigroup[String] = new Semigroup[String] {
    override def combine(x: String, y: String): String = x ++ y
  }

  case class Factura(uuid: Int, concepto: String, cantidad: Int)

  /**
   * No podemos saber si las facturas forman un semigrupo, porque no esá definido el semigrupo de las facturas
   * Sin embargo, queremos definir nuestro propio semigrupo de las facturas. Entonces:
   *
   * Sea la operacion binaria `+:+` tal que dados x e y dos facturas se tiene que x+:+y genera una factura z tal que:
   * - z es una factura
   * - el uuid de z se genera eligiendo el mayor entre el uuid de x y el uuid de y y sumandole 1
   * - el concepto de z se genera concatenando el concepto de x con ' + ' con el concepto de y
   * - la cantidad de z se genera sumando la cantidad de x con la cantidad de y
   * */

  def +:+(x: Factura, y: Factura): Factura = Factura(math.max(x.uuid, y.uuid) + 1, x.concepto + " + " + y.concepto, x.cantidad + y.cantidad)

  /**
   * Esto es una clase implicita y a veces, como es el caso, lo usamos para extender clases que ya están previamente definidas
   * para añadir operaciones infijas del estilo a `x +:+ y` */
  implicit class ImplicitTypeClassFacturas(x: Factura) {
    def +:+(y: Factura): Factura = SemigroupL.+:+(x, y)
    def +/\+(y: Factura): Factura = SemigroupL.+/\+(x, y)
  }

  /** Se tiene que (para nosotros) el conjunto de las facturas con la operacion +:+ forma un semigrupo (pero no un monoide) */
  val facturaSemigrupo: Semigroup[Factura] = new Semigroup[Factura] {
    override def combine(x: Factura, y: Factura): Factura = x +:+ y
  }

  /**
   * De hecho, podemos definir otra operacion binaria:
   * Sea la operacion binaria `+/\+` tal que dados x e y dos facturas se tiene que x+:+y genera una factura z tal que:
   * - z es una factura
   * - el uuid de z se genera sumando el uuid de x y el uuid de y
   * - el concepto de z se genera concatenando el concepto de x con ' & ' con el concepto de y
   * - la cantidad de z se genera transformando en string la cantidad de x y la cantidad de y, concatenandolo y parseandolo a numero
   */

  def +/\+(x: Factura, y: Factura): Factura = Factura(x.uuid+y.uuid, x.concepto + " & " + y.concepto, s"${x.cantidad}${y.cantidad}".toInt)

  /** Se tiene que (para nosotros) el conjunto de las facturas con la operacion +:+ forma un semigrupo (pero no un monoide) */
  val facturaSemigrupo2: Semigroup[Factura] = new Semigroup[Factura] {
    override def combine(x: Factura, y: Factura): Factura = x +/\+ y
  }

  /**
   * Por eso decimos que no existe el semigrupo de facturas, porque es semanticamente ambiguo o no existe una definición formal de que es una factura
   * Tenemos facturas de muchos tipos y la 'fusion' u 'unificación' de facturas no es única.
   */

  /**
   * Tambien podemos generar el semigrupo de las facturas formado por la operacion que a cada componente o parametro se combine segun el semigrupo de ese tipo
   */
  val facturaSemigrupo3: Semigroup[Factura] = new Semigroup[Factura] {
    override def combine(x: Factura, y: Factura): Factura =
      Factura(numerosSemigrupo.combine(x.uuid, y.uuid), stringsSemigrupo.combine(x.concepto, y.concepto), numerosSemigrupo.combine(x.cantidad, y.cantidad))
  }

  def main(args: Array[String]): Unit = {
    val f1: Factura = Factura(0, "compraA", 10)
    val f2: Factura = Factura(1, "compraB", 7)

    println(numerosSemigrupo.combine(3, 5))
    println(listasSemigrupo.combine(List(1, 2, 3), List(4, 5, 6)))
    println(facturaSemigrupo.combine(f1, f2))
    println(facturaSemigrupo2.combine(f1, f2))
    println(facturaSemigrupo3.combine(f1, f2))
  }
}
