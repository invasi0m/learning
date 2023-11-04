package io.github.rafafrdz.nat

trait Nat

object Nat {

  class Z extends Nat

  class Succ[N <: Nat] extends Nat


  type _0 = Z
  type _1 = Succ[_0]
  type _2 = Succ[_1] // ~> Succ[Succ[_0]]
  type _3 = Succ[_2] // ~> Succ[Succ[_1]] ~> Succ[Succ[Succ[_0]]]
  type _4 = Succ[_3] // ~> Succ[Succ[_2]] ~> Succ[Succ[Succ[_1]]] ~> Succ[Succ[Succ[Succ[_0]]]}
  type _5 = Succ[_4] // etc.


}
