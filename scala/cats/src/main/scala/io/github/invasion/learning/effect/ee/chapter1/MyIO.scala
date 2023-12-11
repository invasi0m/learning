package io.github.invasion.learning.effect.ee.chapter1

case class MyIO[T](unsafeRun: () => T) {

  def map[U](f: T => U): MyIO[U] =
    MyIO(() => f(unsafeRun()))

  def flatMap[U](f: T => MyIO[U]): MyIO[U] =
    MyIO(() => f(unsafeRun()).unsafeRun())
}

object MyIO {
  def pure[T](value: => T): MyIO[T] = MyIO(() => value)
}
