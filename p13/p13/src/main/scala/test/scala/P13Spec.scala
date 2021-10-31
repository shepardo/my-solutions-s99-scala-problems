package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P13Test extends AnyFunSuite with Matchers {

  test("test with empty list") {
    val p12 = new P12[Int]()
    p12.decode(List()) should be(List())
  }

  test("test with 1 element") {
    val p12 = new P12[Int]()
    p12.decode(List(1)) should be(List(1))
  }

  test("test with 1 tuple") {
    val p12 = new P12[Int]()
    p12.decode(List((3, 2))) should be(List(2, 2, 2))
  }

  test("test original test case") {
    val p12 = new P12[Symbol]()
    p12.decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) should 
      be(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }
}