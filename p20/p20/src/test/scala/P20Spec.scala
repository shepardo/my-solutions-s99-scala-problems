package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P20Spec extends AnyFunSuite with Matchers {

  test("empty list") {
    val p20 = new P20[Symbol]()
    assertThrows[IllegalArgumentException] {
      p20.removeAt(1, List())
    }
  }

  test("original test case") {
    val p20 = new P20[Symbol]()
    p20.removeAt(1, List('a, 'b, 'c, 'd)) should be((List('a, 'c, 'd),'b))
  }

  test("original test case, var 1") {
    val p20 = new P20[Symbol]()
    p20.removeAt(0, List('a, 'b, 'c, 'd)) should be((List('b, 'c, 'd),'a))
  }

  test("original test case, var 2") {
    val p20 = new P20[Symbol]()
    p20.removeAt(3, List('a, 'b, 'c, 'd)) should be((List('a, 'b, 'c),'d))
  }

}