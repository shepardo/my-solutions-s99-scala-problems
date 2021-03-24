package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P17Spec extends AnyFunSuite with Matchers {

  test("with empty list") {
    val p17 = new P17[Int]()
    p17.split(3, List()) should be(List(), List())
  }

  test("with 1 element list") {
    val p17 = new P17[Int]()
    p17.split(3, List(1)) should be(List(1), List())
  }

  test("with items in firs result") {
    val p17 = new P17[Int]()
    p17.split(5, List(1, 2, 3, 4, 5)) should be((List(1, 2, 3, 4, 5), List()))
  }

  test("with all but one element in first result") {
    val p17 = new P17[Int]()
    p17.split(4, List(1, 2, 3, 4, 5)) should be((List(1, 2, 3, 4), List(5)))
  }

  test("with original test case") {
    val p17 = new P17[Symbol]()
    p17.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should 
      be((List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
}