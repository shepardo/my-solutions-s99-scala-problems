package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P23Spec extends AnyFunSuite with Matchers {

  test("empty list") {
    val p23 = new P23[Symbol]()
    p23.randomSelect(3, List()) should be(List())
  }

  test("more removable that original items") {
    val p23 = new P23[Symbol]()
    val result = p23.randomSelect(5, List('a, 'b, 'c ))
    result should be(result)
  }

  test("original test case") {
    val p23 = new P23[Symbol]()
    val result = p23.randomSelect(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h))
    result should be(result)
  }
}