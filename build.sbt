lazy val root = (project in file(".")).
    settings(
            name := "PerlVersions",
            version := "1.0",
            scalaVersion := "2.11.4",
            libraryDependencies += "org.specs2" %% "specs2-core" % "2.4.15" % "test",
            libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
            libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.9"

            )
