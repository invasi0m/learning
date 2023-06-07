  package io.github.invasion.doobie

  import cats.effect.kernel.Async
  import cats.effect.{ExitCode, IO, IOApp}
  import doobie.implicits._
  import doobie.util.transactor.Transactor
  import doobie.util.transactor.Transactor.Aux

  object Example extends IOApp{


    /** It works because postgressql is in the classpath right now */
    def conn[F[_]: Async]: Aux[F, Unit] =
    Transactor.fromDriverManager[F](
    driver = "org.postgresql.Driver",
    url = "jdbc:postgresql://localhost:5432/world",
    user = "postgres",
    pass = "postgres"
    )

    case class City(id: Int, name: String, countrycode: String, district: String, population: Int)
    val q0: doobie.Query0[City] = sql"select * from city c".query[City]

    override def run(args: List[String]): IO[ExitCode] =
      for {
        cities <- q0.to[List].transact(conn[IO])
        _ <- IO.println(cities)
      } yield ExitCode.Success

  }



