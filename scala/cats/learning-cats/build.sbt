version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(name := "learning-cats"  )

val catsVersion = "2.9.0"

// https://mvnrepository.com/artifact/org.typelevel/cats-core
libraryDependencies += "org.typelevel" %% "cats-core" % catsVersion
scalacOptions ++= Seq(
  "-language:higherKinds"
)