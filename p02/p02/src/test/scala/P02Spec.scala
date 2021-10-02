package com.shepardo.p99

// https://stackoverflow.com/questions/29972284/scalatest-on-sbt-not-running-any-tests

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P02Test extends AnyFunSuite with Matchers {

  def createGenerators = { 
    val gens = Array(new P02Mine[Int](), new P02PenultimateBuiltin[Int](), new P02PenultimateRecursive[Int]())
    for( x <- gens) yield x
  }

  test("that returns element for single element's list") {
    for (p02 <- createGenerators) {
      p02.penultimate(List(3)) should equal(None)
    }
  }

  test("that returns none for empty list") {
    for (p02 <- createGenerators) {
      p02.penultimate(List()) should be(None)
    }
  }

  test("that returns last element of list") {
    for (p02 <- createGenerators) {
      p02.penultimate(List(1, 1, 2, 3, 5, 8)) should be(Some(5))
    }
  }
}