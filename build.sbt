name := "im"

version := "0.1"

scalaVersion := "2.12.8"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.23",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.23" % "test",
  "org.scalatest" %% "scalatest" % "3.0.7" % "test",
  "com.typesafe.akka" %% "akka-remote" % "2.5.23"
  
)