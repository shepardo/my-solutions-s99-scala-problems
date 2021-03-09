package com.shepardo.p99

// https://stackoverflow.com/questions/29972284/scalatest-on-sbt-not-running-any-tests

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P02Test extends AnyFunSuite with Matchers {

  val p02 = new P02[Int]()

  test("that returns element for single element's list") {
    p02.penultimate(List(3)) should equal(None)
  }

  test("that returns none for empty list") {
    p02.penultimate(List()) should be(None)
  }

  test("that returns last element of list") {
    p02.penultimate(List(1, 1, 2, 3, 5, 8)) should be(Some(5))
  }
}