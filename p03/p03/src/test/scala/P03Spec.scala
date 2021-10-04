package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P03Test extends AnyFunSuite with Matchers {

  def createGenerators[T] = { 
    val gens = Array(new P03Mine[T](), new P03Builtin[T](), new P03Recursive[T]())
    for(x <- gens) yield x
  }

  test("that returns element for single element's list") {
    for (p03 <- createGenerators[Int]) {
      p03.nth(0, List(3)) should equal(Some(3))
      p03.nth(2, List(3)) should equal(None)
    }
  }

  test("that returns none for empty list") {
    for (p03 <- createGenerators[Int]) {
      p03.nth(0, List()) should be(None)
      p03.nth(7, List()) should be(None)
    }
  }

  test("that return the nth element") {
    for (p03 <- createGenerators[Int]) {
      p03.nth(2, List(1, 1, 2, 3, 5, 8)) should be(Some(2))
      p03.nth(4, List(1, 1, 2, 3, 5, 8)) should be(Some(5))
    }
  }
}