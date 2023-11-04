package io.github.rafafrdz.vector

import io.github.rafafrdz.nat.Nat._
import io.github.rafafrdz.nat._

sealed trait Vec[N <: Nat, +T]

object Vec {

  case object VNil extends Vec[_0, Nothing]

  case class Cons[N <: Nat, +T](elem: T, vec: Vec[N, T]) extends Vec[Succ[N], T]

  def --[N <: Nat, T]: Vec[_0, T] = VNil

  def ::[N <: Nat, T](e: T, vs: Vec[N, T]): Vec[Succ[N], T] = Cons(elem = e, vec = vs)
}
