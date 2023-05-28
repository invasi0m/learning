package io.github.invasion.server.services

import cats.effect.Async
import cats.effect.std.Console
import cats.implicits._
import imputation._
object Users {

  private val user1Dummy: User = User("1", "name", Status("employed"), Job("developer"), List(Role("admin")))
  private val user2Dummy: User = User("2", "name", Status("employed"), Job("developer"), List(Role("user")))

  def impl[F[_]: Async: Console]: UserService[F] = new UserService[F] {

    val logger: Console[F] = implicitly[Console[F]]
    def getUser(id: String): F[User] =
      logger.println(s"Getting user with id: $id") *>
        user1Dummy.pure[F]

    def getUsers(): F[GetUsersOutput] =
      logger.println("Getting all users") *>
        GetUsersOutput(Option(List(user1Dummy, user2Dummy))).pure[F]

    def createUser(name: String, status: Status, job: Job, role: List[Role]): F[CreateUserOutput] =
      logger.println(s"Creating users with name: $name, status: $status, job: $job, role: ${role.mkString(",")}") *>
        CreateUserOutput(Option("3")).pure[F]

    def editUser(
        id: String,
        name: Option[String],
        status: Option[Status],
        job: Option[Job],
        role: Option[List[Role]]
    ): F[EditUserOutput] =
      logger.println(
        s"Editing users with id: $id, name: $name, status: $status, job: $job, role: ${role.mkString(",")}"
      ) *>
        EditUserOutput(Option(id)).pure[F]

    def deleteUser(id: String): F[DeleteUserOutput] =
      logger.println(s"Deleting user with id: $id") *>
        DeleteUserOutput(Option(id)).pure[F]

  }

}
