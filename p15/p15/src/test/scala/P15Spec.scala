package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P15Spec extends AnyFunSuite with Matchers {

  test("test with empty list") {

  }

  test("test with 1 element list") {

  }

  test("test case original") {
    val p15 = new P15[Symbol]()
    p15.duplicateN(3, List('a, 'b, 'c, 'c, 'd)) should be(List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }
}