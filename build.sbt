import Dependencies._

ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.thecoders"
ThisBuild / organizationName := "The Coders"

lazy val root = (project in file("."))
  .settings(
    name := "csv-validator",
    libraryDependencies ++= Seq(scalactic, scalatest)
  )
