package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P05Test extends AnyFunSuite with Matchers {

  val p05 = new P05[Int]()

  test("that returns the reverse of a single item list") {
    p05.reverse(List(3)) should equal(List(3))
  }

  test("that returns the reverse of an empty list") {
    p05.reverse(List()) should be(Nil)
  }

  test("that returns the reverse of a list with several items") {
    p05.reverse(List(1, 1, 2, 3, 5, 8)) should be(List(8, 5, 3, 2, 1, 1))
  }
}