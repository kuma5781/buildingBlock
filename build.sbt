name := """buildingBlock"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  guice,
  jdbc,
  "mysql" % "mysql-connector-java" % "8.0.15",
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
)
