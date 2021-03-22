package com.shepard.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P11Test extends AnyFunSuite with Matchers {

  test("A test case empty list") {
    val p11 = new P11[Int]()
    p11.encodeModified(List()) should be(List())
  }

  test("A test case w/ 1 element") {
    val p11 = new P11[Int]()
    p11.encodeModified(List(1)) should be(List(1))
  }

  test("Another test case") {
    val p11 = new P11[Int]()
    p11.encodeModified(List(1, 2, 3, 3, 4, 5, 5, 5)) should be(List(1, 2, (2, 3), 4, (3, 5)))
  }

  test("Test original test case") {
    val p11 = new P11[Symbol]()
    p11.encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should
      be (List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
  }
}