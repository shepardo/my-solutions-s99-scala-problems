package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P08Test extends AnyFunSuite with Matchers {

  test("that returns the compress of a single item list") {
    val p08 = new P08[Int]()
    p08.compress(List(3)) should be(List(3))
  }

  test("that returns the compress of an empty list") {
    val p08 = new P08[Int]()
    p08.compress(List()) should be(List())
  }

  test("that returns the compress of a list with several items") {
    val p08 = new P08[Symbol]()
    p08.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be(List('a, 'b, 'c, 'a, 'd, 'e))
  }
}