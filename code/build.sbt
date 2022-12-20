lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "indigo",
      scalaVersion := "3.2.0"
    )),
    name := "adventOfCode"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
