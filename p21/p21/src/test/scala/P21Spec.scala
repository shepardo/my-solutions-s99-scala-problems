package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P21Spec extends AnyFunSuite with Matchers {

  test("empty list") {
    val p21 = new P21[Symbol]()
    p21.insertAt('new, 2, List()) should be(List())
  }

  test("original test case") {
    val p21 = new P21[Symbol]()
    p21.insertAt('new, 1, List('a, 'b, 'c, 'd)) should be(List('a, 'new, 'b, 'c, 'd))
  }

  test("insert at end") {
    val p21 = new P21[Symbol]()
    p21.insertAt('new, 3, List('a, 'b, 'c, 'd)) should be(List('a, 'b, 'c, 'new, 'd))
  }

    test("insert at end, end") {
    val p21 = new P21[Symbol]()
    p21.insertAt('new, 4, List('a, 'b, 'c, 'd)) should be(List('a, 'b, 'c, 'd, 'new))
  }
}