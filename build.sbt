lazy val root = (project in file(".")).
    settings(
            name := "PerlVersions",
            version := "1.0",
            scalaVersion := "2.11.4",
            libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.3" % "test",
            libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
            libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.9"
            )
