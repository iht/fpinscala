name := "Functional Programming in Scala - Solutions to the exercises"

version := "0.1"

scalaVersion := "2.10.4"

libraryDependencies += "org.specs2" %% "specs2" % "2.3.9" % "test"

resolvers ++= Seq(Resolver.sonatypeRepo("releases"),
                  Resolver.sonatypeRepo("snaspshots"),
                  "cloudera"           at "http://repository.cloudera.com/content/repositories/releases",
                  "Local repository"   at "http://orinet.nce.amadeus.net/artifacts/mavenrepo/")

javacOptions in Compile ++= Seq("-source", "1.6",  "-target", "1.6") 

scalacOptions += "-target:jvm-1.6"

//packageArchetype.java_application

//javaOptions += "-Xmx5G"
