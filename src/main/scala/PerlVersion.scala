package com.github.magnolia_k.perl_version

import scala.concurrent._
import scala.concurrent.duration.Duration

import dispatch._, Defaults._

case class PerlVersion(ver: String) {
    private val matched = PerlVersion.re_ver.findAllIn(ver)
    if (matched.hasNext != true) {
        throw new IllegalArgumentException("ver must be a perl version number") 
    }

    if (PerlVersion.allVersions.contains(ver) != true) {
        throw new IllegalArgumentException("ver must be a perl version number") 
    }

    val major = matched.group(1).toInt

    def isStable: Boolean = { major % 2 == 0 }
    def url: String = { PerlVersion.site + "perl-" + ver + ".tar.gz" }
}

object PerlVersion {
    lazy val allVersions = getAll()

    val re_ver = """5\.(\d{1,2})\.\d""".r
    val site   = "http://www.cpan.org/src/5.0/"

    def getAll(): List[String] = {
        val re   = """<a href="perl-(5\.(\d{1,2})\.\d)\.tar\.gz">.*?</a>""".r
        val request = Http(url(site) OK as.String)

        val result: String = Await.result(request, Duration.Inf)

        for (m <- re.findAllMatchIn(result).toList) yield m.group(1).toString
    }
}
