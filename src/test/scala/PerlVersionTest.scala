package com.github.magnolia_k.perl_version

import org.scalatest.FunSuite

class PerlVersionTest extends FunSuite {
    test("Invalid param pattern") {
        try {
            val invalid = new PerlVersion("a.bc.d")
        } catch {
            case _: java.lang.IllegalArgumentException =>
        }
    }

    test("Valid param pattern") {
        val version = new PerlVersion("5.20.1")

        assert(version.ver == "5.20.1")
        assert(version.url == "http://www.cpan.org/src/5.0/perl-5.20.1.tar.gz")
    }
}
