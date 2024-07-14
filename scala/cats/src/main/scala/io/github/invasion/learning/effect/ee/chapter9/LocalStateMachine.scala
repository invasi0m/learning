package io.github.invasion.learning.effect.ee.chapter9

import cats.effect._
import cats.effect.std.Console
import cats.effect.unsafe.implicits.global
import cats.implicits._
import io.github.invasion.learning.effect.ee.debug._

import scala.concurrent.duration._

/**
 * This state machine will await to do "something" until the prerequisites would be holds
 */
object LocalStateMachine extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    for {
      machine <- StateMachine.create()
      _ <- (
        actionWithPrerequisites(machine),
        prerequisites(machine)
      ).parTupled // do both (action and check prerequisites parallel)
    } yield ExitCode.Success

  def actionWithPrerequisites(machine: StateMachine): IO[String] =
    for {
      _ <- IO("waiting for prerequisites").color
      _ <- machine.await // waiting until prerequisites holds
      result <- IO("action").color
    } yield result

  def prerequisites(machine: StateMachine): IO[String] =
    for {
      result <- IO("do prerequisites").color
      _ <- IO.sleep(3.seconds) // here do "some" prerequisites (simulated by delaying 3 seconds)
      _ <- machine.check // check prerequisites ("blocks" thread)
    } yield result

  /** State Machine */
  sealed trait StateMachine {
    def await: IO[Unit]
    def check: IO[Unit]
  }
  object StateMachine {

    def create(): IO[StateMachine] = create(false)

    def create(bool: Boolean): IO[StateMachine] =
      for {
        whenDone <- Deferred[IO, Unit]
        state <- Ref[IO].of[State](Pending(bool, whenDone))
      } yield new StateMachine {
        override def await: IO[Unit] =
          for {
            st <- state.get
            _ <- st match {
              case Done() => IO.unit
              case Pending(_, whenDone) => whenDone.get
            }
          } yield ()

        override def check: IO[Unit] = {
          val newState: IO[Boolean] =
            Console[IO].println("Escribe una palabra de cuatro letras: ") *>
              Console[IO].readLine
                .map(_.length == 4)

          state.flatModify {
            case Pending(true, whenDone) =>
              Done() -> whenDone.complete(()) *> IO.unit
            case Pending(false, whenDone) =>
              Pending(newState.unsafeRunSync(), whenDone) -> check
            case Done() => Done() -> check
          }

        }
      }
  }

  /** Model State */
  sealed trait State
  case class Done() extends State
  case class Pending(state: Boolean, whenDone: Deferred[IO, Unit]) extends State

}
