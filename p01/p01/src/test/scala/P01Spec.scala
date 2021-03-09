package com.shepardo.p99

// https://stackoverflow.com/questions/29972284/scalatest-on-sbt-not-running-any-tests

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P01Test extends AnyFunSuite with Matchers {

  val p01 = new P01[Int]()

  test("that returns element for single element's list") {
    p01.last(List(3)) should equal(Some(3))
  }

  test("that returns none for empty list") {
    p01.last(List()) should be(None)
  }

  test("that returns last element of list") {
    p01.last(List(1, 1, 2, 3, 5, 8)) should be(Some(8))
  }
}