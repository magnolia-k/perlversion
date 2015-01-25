package com.github.magnolia_k.perl_version

import org.specs2._

class PerlVersionSpec extends Specification {
  
  val version = new PerlVersion("5.20.1")

  def is = s2"""

これはPerlVersionの仕様です。

PerlVersionは…
  a.bc.cはダメなバージョン形式  $e1

  5.20.1は
    妥当なバージョン      $e2
    安定バージョン        $e3
    URLは正しく取得 ${version.url}      $e4
"""


  def e1 = {
      val invalid = new PerlVersion("a.bc.d")
    } must throwA[java.lang.IllegalArgumentException]

  def e2 = version.ver must contain("5.20.1")
  def e3 = version.isStable must beTrue
  def e4 = version.url must
    contain("http://www.cpan.org/src/5.0/perl-5.20.1.tar.gz")
}
