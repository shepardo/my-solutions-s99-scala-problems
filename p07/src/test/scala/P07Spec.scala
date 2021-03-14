package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P07Test extends AnyFunSuite with Matchers {

  val p07 = new P07[Int]()

  test("that returns the flatten of a single item list") {
    p07.flatten(List(3)) should be(List(3))
  }

  test("that returns the flatten of an empty list") {
    p07.flatten(List()) should be(List())
  }

  test("that returns the flatten of a list with several items") {
    //p07.flatten(List(1, 2, 3, 2, 1)) should be(true)
    p07.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) should be(List(1, 1, 2, 3, 5, 8))
  }
}