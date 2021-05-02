package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P23Spec extends AnyFunSuite with Matchers {
  test("original test case") {
    val p23 = new P23[Symbol]()
    p23.randomSelect(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h)) should be(List('e, 'd, 'a))
  }
}