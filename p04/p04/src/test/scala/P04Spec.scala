package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P04Test extends AnyFunSuite with Matchers {

  val p04 = new P04[Int]()

  test("that returns count for single element's list") {
    p04.length(List(3)) should equal(1)
  }

  test("that returns zero for empty list") {
    p04.length(List()) should be(0)
  }

  test("that return the count of elements") {
    p04.length(List(1, 1, 2, 3, 5, 8)) should be(6)
    p04.length(List(1, 1, 2, 3, 5, 8, 9, 10, 11)) should be(9)
  }
}