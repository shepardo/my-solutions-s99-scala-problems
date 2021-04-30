package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P22Spec extends AnyFunSuite with Matchers { 

  test("empty list") {
    val p22 = new P22()
    p22.range(3, 2) should be(List())
  }

  test("original test case") {
    val p22 = new P22()
    p22.range(4, 9) should be(List(4, 5, 6, 7, 8, 9))
  }

  test("original test case 2nd") {
    val p22 = new P22()
    p22.range(3, 11) should be(List(3, 4, 5, 6, 7, 8, 9, 10, 11))
  }
}
