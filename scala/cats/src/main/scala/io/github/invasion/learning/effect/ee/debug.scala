package io.github.invasion.learning.effect.ee

import cats.effect._

/**
 * `import io.github.invasion.learning.effect.ee.debug._` to access
 * the `debug` extension methods.
 */
object debug {

  /** Extension methods for an effect of type `F[A]`. */
  implicit class DebugHelper[A](ioa: IO[A]) {

    /**
     * Print to the console the value of the effect
     * along with the thread it was computed on.
     */
    def color: IO[A] =
      for {
        a <- ioa
        tn = Thread.currentThread.getName
        _ = println(s"[${Colorize.reversed(tn)}] $a") // <1>
      } yield a
  }

  object Colorize {
    def apply(a: Any): String =
      s"${colors(a.hashCode.abs % numColors)}$a${Console.RESET}"

    def reversed(a: Any): String =
      s"${Console.REVERSED}${apply(a)}"

    private val colors = List(
      Console.WHITE,
      Console.BLACK + Console.WHITE_B,
      Console.RED,
      Console.GREEN,
      Console.YELLOW,
      Console.BLUE,
      Console.MAGENTA,
      Console.CYAN
    )
    private val numColors = colors.size - 1
  }

}
