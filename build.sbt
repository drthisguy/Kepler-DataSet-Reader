ThisBuild / organization := "com.scalawags"

name := "KeplerDataReader"
version := "1.0"
scalaVersion := "2.13.4"

lazy val kepler = (project in file(".")).settings(
    name := "Kepler Data Reader",
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.2",
      libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % "test"
    )