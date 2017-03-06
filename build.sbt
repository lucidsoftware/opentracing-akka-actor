lazy val `akka-actor-thread-context` = project.cross

lazy val `akka-actor-thread-context_2.11` = `akka-actor-thread-context`("2.11.8")
lazy val `akka-actor-thread-context_2.12` = `akka-actor-thread-context`("2.12.1")

inScope(Global)(Seq(
  credentials += Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", sys.env.getOrElse("SONATYPE_USERNAME", ""), sys.env.getOrElse("SONATYPE_PASSWORD", "")),
  developers += Developer("pauldraper", "Paul Draper", "paulddraper@gmail.com", url("https://github.com/pauldraper")),
  homepage := Some(url("https://git.lucidchart.com/lucidsoftware/akka-thread-context")),
  licenses += "Apache 2.0 License" -> url("https://www.apache.org/licenses/LICENSE-2.0"),
  organization := "com.lucidchart",
  organizationHomepage := Some(url("http://github.com/lucidsoftware")),
  organizationName := "Lucid Software",
  PgpKeys.pgpPassphrase := Some(Array.emptyCharArray),
  resolvers += Resolver.typesafeRepo("releases"),
  scalaVersion := "2.11.8",
  scmInfo := Some(ScmInfo(
    url("https://github.com/lucidsoftware/akka-thread-context"),
    "scm:git:git@github.com:lucidsoftware/akka-thread-context.git"
  )),
  startYear := Some(2017),
  version := sys.props.getOrElse("build.version", "0-SNAPSHOT")
))
