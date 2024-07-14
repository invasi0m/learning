version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(name := "learning-cats")

val catsVersion = "2.9.0"
val catsEffectVersion = "3.5.1"
val scalaTestVersion = "3.2.15"

// https://mvnrepository.com/artifact/org.typelevel/cats-core
libraryDependencies += "org.typelevel" %% "cats-core" % catsVersion
libraryDependencies += "org.scalactic" %% "scalactic" % scalaTestVersion
libraryDependencies += "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
// https://mvnrepository.com/artifact/org.typelevel/cats-effect
libraryDependencies += "org.typelevel" %% "cats-effect" % catsEffectVersion
// https://mvnrepository.com/artifact/org.typelevel/cats-effect-laws
libraryDependencies += "org.typelevel" %% "cats-effect-laws" % catsEffectVersion

scalacOptions ++= Seq(
  "-language:higherKinds"
)
