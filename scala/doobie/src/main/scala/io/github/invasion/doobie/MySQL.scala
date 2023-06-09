  package io.github.invasion.doobie

import cats.effect.kernel.Async
import cats.effect.{ExitCode, IO, IOApp}
import doobie.implicits._
import doobie.util.transactor.Transactor
import doobie.util.transactor.Transactor.Aux

  object MySQL extends IOApp {


    /** It works because postgressql is in the classpath right now */
    def conn[F[_]: Async]: Aux[F, Unit] =
    Transactor.fromDriverManager[F](
    driver = "com.mysql.cj.jdbc.Driver",
    url = "jdbc:mysql://localhost:3306/world",
    user = "root",
    pass = "mysql"
    )

    case class City(id: Int, name: String, countrycode: String, district: String, population: Int)
    val q0: doobie.Query0[City] = sql"select * from city c".query[City]

    override def run(args: List[String]): IO[ExitCode] =
      for {
        cities <- q0.to[List].transact(conn[IO])
        _ <- IO.println(cities)
      } yield ExitCode.Success

  }



