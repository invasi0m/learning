ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "doobie"
  )



lazy val doobieCore  = "org.tpolecat" %% "doobie-core" % "1.0.0-RC2"
lazy val doobiePostgres = "org.tpolecat" %% "doobie-postgres" % "1.0.0-RC2"
lazy val catsCore = "org.typelevel" %% "cats-core" % "2.7.0"
lazy val catsEffect = "org.typelevel" %% "cats-effect" % "3.3.12"

lazy val postrgeSQLDriver = "org.postgresql" % "postgresql" % "42.6.0"


libraryDependencies ++= Seq(
  catsCore,
  catsEffect,
  doobieCore,
  postrgeSQLDriver
//  doobiePostgres
)