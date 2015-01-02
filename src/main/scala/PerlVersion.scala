package com.github.magnolia_k.perl_version

import scala.io.Source

case class PerlVersion(ver: String) {
    private val found = PerlVersion.allVersions.find(x => ver == x)
    found match {
        case Some(matched) => {
            private val re = """^5\.(\d{1,2})\.\d$""".r
            private val major = re.findAllIn(ver)

        }
        case None => throw new IllegalArgumentException("ver must be a perl version number")
    }

    private val matched = """^5\.(\d{1,2})\.\d$""".r.findAllIn(ver)
    if (matched.hasNext != true) {
        throw new IllegalArgumentException("ver must be a perl version number") 
    }

    val major = matched.group(1).toInt

    def isStable: Boolean = { major % 2 == 0 }
    def url: String = { "http://www.cpan.org/src/5.0/perl-" + ver + ".tar.gz" }
}

object PerlVersion {
    lazy val allVersions = getAll()

    def getAll(): List[String] = {
        val url    = "http://www.cpan.org/src/5.0/"
        val regexp = """<a href="perl-(5\.(\d{1,2})\.\d)\.tar\.gz">.*?</a>""".r
        val html   = Source.fromURL(url).mkString

        for (m <- regexp.findAllMatchIn(html).toList) yield m.group(1).toString
    }

    def getVersionsByMajor(major: String): List[String] = {
        List("1")
    }
}
