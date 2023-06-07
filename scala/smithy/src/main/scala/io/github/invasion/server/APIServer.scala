package io.github.invasion.server

import cats.effect.std.Console
import cats.effect.{Async, Resource}
import cats.implicits._
import com.comcast.ip4s._
import imputation.UserService
import io.github.invasion.server.services.Users
import org.http4s.HttpRoutes
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.Server
import smithy4s.http4s.SimpleRestJsonBuilder

object APIServer {

  def docs[F[_]: Async]: HttpRoutes[F] =
    smithy4s.http4s.swagger
      .docs[F](
        UserService
      )

  def resources[F[_]: Async: Console]: Resource[F, HttpRoutes[F]] =
    SimpleRestJsonBuilder
      .routes(
        Users.impl
      )
      .resource

  def server[F[_]: Async: Console](routes: HttpRoutes[F]): Resource[F, Server] =
    EmberServerBuilder
      .default[F]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"8080")
      .withHttpApp(routes.orNotFound)
      .build

  def run[F[_]: Async: Console]: F[Nothing] = {
    val logger: Console[F] = implicitly[Console[F]]
    val httpServer: Resource[F, Server] =
      for {
        routes <- resources
        all = routes <+> docs[F]
        srv <- server(all)
      } yield srv

    httpServer
      .evalMap(srv => logger.println(srv.addressIp4s))
      .useForever
  }
}
