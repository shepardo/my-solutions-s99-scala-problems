package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P03Test extends AnyFunSuite with Matchers {

  val p03 = new P03[Int]()

  test("that returns element for single element's list") {
    p03.nth(0, List(3)) should equal(Some(3))
    p03.nth(2, List(3)) should equal(None)
  }

  test("that returns none for empty list") {
    p03.nth(0, List()) should be(None)
    p03.nth(7, List()) should be(None)
  }

  test("that return the nth element") {
    p03.nth(2, List(1, 1, 2, 3, 5, 8)) should be(Some(2))
    p03.nth(4, List(1, 1, 2, 3, 5, 8)) should be(Some(5))
  }
}