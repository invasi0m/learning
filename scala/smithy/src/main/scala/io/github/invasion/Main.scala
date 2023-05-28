package io.github.invasion

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._
import io.github.invasion.server.APIServer

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    APIServer.run[IO] <*> ExitCode.Success.pure[IO]
}
