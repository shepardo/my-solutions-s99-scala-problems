package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P14Spec extends AnyFunSuite with Matchers {

  test("test empty list") {
    val p14 = new P14[Int]()
    p14.duplicate(List()) should be(List())
  }

  test("test with 1 element list") {
    val p14 = new P14[Int]()
    p14.duplicate(List(1)) should be(List(1, 1))
  }

  test("test original case") {
    val p14 = new P14[Symbol]()
    p14.duplicate(List('a, 'b, 'c, 'c, 'd)) should be(List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
  }
}