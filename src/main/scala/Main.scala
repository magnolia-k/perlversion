package com.github.magnolia_k.perl_version

object Main {
  def main(args: Array[String]) = {
    val perlVersions = PerlVersion.allVersions

    perlVersions.foreach((s: String) => println(s))
  }
}
