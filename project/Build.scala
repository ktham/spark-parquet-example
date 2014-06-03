import sbt._
import Keys._

object Build extends Build {
  val sparkV = "1.0.0"

  lazy val project = Project(
    "project",
    file("."),
    settings = Defaults.coreDefaultSettings ++ Seq(
      organization := "spark-examples",
      name := "spark-examples",
      version := "0.0.1",
      scalaVersion := "2.10.4",
      resolvers ++= Seq(
        Classpaths.sbtPluginReleases,
        "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
        "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/"
      ),
      libraryDependencies ++= Seq(
        "org.apache.spark" %% "spark-core" % sparkV,
        "org.apache.spark" %% "spark-sql" % sparkV
      )
    )
  )
}
