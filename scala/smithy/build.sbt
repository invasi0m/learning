import smithy4s.codegen.Smithy4sCodegenPlugin

val root = project
  .in(file("."))
  .settings(
    scalaVersion := "2.13.10",
    name := "smith4s-learning",
    organization := "io.github.invasion",
    version := "1.0",
    libraryDependencies ++= Seq(
      // https://github.com/plokhotnyuk/jsoniter-scala/issues/933
      "com.disneystreaming.smithy4s" %% "smithy4s-http4s" % smithy4sVersion.value,
      "com.disneystreaming.smithy4s" %% "smithy4s-http4s-swagger" % smithy4sVersion.value,
      "org.http4s" %% "http4s-ember-server" % "0.23.18"
    ),
    fork := true
  )
  .enablePlugins(Smithy4sCodegenPlugin)

