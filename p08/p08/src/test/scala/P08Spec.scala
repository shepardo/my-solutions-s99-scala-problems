package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P07Test extends AnyFunSuite with Matchers {

  val p08 = new P08[Char]()

  test("that returns the compress of a single item list") {
    //p08.flatten(List(3)) should be(List(3))
  }

  test("that returns the compress of an empty list") {
    //p08.flatten(List()) should be(List())
  }

  test("that returns the compress of a list with several items") {
    p08.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be(List('a, 'b, 'c, 'a, 'd, 'e'))
  }
}