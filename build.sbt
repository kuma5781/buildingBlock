name := """buildingBlock"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

// 4.0.0だとscala-parser-combinatorsとのバージョンの互換性がなかったので仕方なく3.5.0
val scalikejdbcVersion = "3.5.0"

libraryDependencies ++= Seq(
  guice,
  jdbc,
  "mysql" % "mysql-connector-java" % "8.0.15",
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "org.scalikejdbc" %% "scalikejdbc"        % scalikejdbcVersion,
  "org.scalikejdbc" %% "scalikejdbc-config"           % scalikejdbcVersion,
  "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.8.0-scalikejdbc-3.5",
  "org.scalikejdbc" %% "scalikejdbc-play-dbapi-adapter" % "2.8.0-scalikejdbc-3.5"
)
