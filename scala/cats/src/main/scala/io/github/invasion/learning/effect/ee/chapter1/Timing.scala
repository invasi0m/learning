package io.github.invasion.learning.effect.ee.chapter1

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.FiniteDuration

object Timing extends App {

  val clock: MyIO[Long] = MyIO(() => System.currentTimeMillis())

  def time[A](action: MyIO[A]): MyIO[(FiniteDuration, A)] = {

    /**
     * Version FlatMap
     * clock.flatMap(l => action.flatMap(a => MyIO(() => (FiniteDuration(l, TimeUnit.NANOSECONDS), a))))
     */

    /** Version for-comprehension */
    for {
      l <- clock
      a <- action
    } yield (FiniteDuration(l, TimeUnit.NANOSECONDS), a)
  }

  val timedHello = Timing.time(MyIO.pure("hello"))

  timedHello.unsafeRun() match {
    case (duration, hello) => println(s"'$hello' took $duration")
  }
}
