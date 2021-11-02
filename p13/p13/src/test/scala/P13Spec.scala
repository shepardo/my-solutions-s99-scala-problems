package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P13Test extends AnyFunSuite with Matchers {

  test("test original test case") {
    val p13 = new P13[Symbol]()
    p13.encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should 
      be(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  }

  test("test with empty list") {
    val p13 = new P13[Int]()
    p13.encodeDirect(List()) should be(List())
  }

  test("single number test case") {
    val p13 = new P13[Symbol]()
    p13.encodeDirect(List('a, 'a, 'a, 'a, 'a, 'a, 'a)) should 
      be(List((7, 'a)))
  }
}