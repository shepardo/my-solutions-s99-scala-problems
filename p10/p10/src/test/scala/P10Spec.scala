package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P10Test extends AnyFunSuite with Matchers {
  
  test("that returns the encode of a single item list") {
    val p10 = new P10[Int]()
    p10.encode(List(3)) should be(List((1, 3)))
  }

  test("that returns the encode of an empty list") {
    val p10 = new P10[Int]()
    p10.encode(List()) should be(List())
  }

  test("that returns the encode of a list with several items") {
    val p10 = new P10[Symbol]()
    p10.encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should 
      be(List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }
}