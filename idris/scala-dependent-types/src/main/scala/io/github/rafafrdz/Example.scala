package io.github.rafafrdz

import io.github.rafafrdz.nat.Nat._
import io.github.rafafrdz.vector.Vec
import io.github.rafafrdz.vector.Vec._

object Example {

  val vs: Vec[_3, Int] = ::(1, ::(1, ::(1, --)))

  val ds: Vec[_4, Int] = ::(1, ::(1, ::(1, --))) // It doesn't work! :(

  def main(args: Array[String]): Unit = {

    println(vs)

    println(ds)

  }

}
