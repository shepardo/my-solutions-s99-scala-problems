package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P15Spec extends AnyFunSuite with Matchers {

  def createGenerators[T] = {
    val gens = Array(new P15Mine[T](), new P15Functional[T]())
    for(x <- gens) yield x
  }

  test("test with empty list") {
    for (p15 <- createGenerators[Symbol]) {
      p15.duplicateN(2, List()) should be(List())
    }
  }

  test("test with 1 element list") {
    for (p15 <- createGenerators[Symbol]) {
      p15.duplicateN(4, List('a)) should be(List('a, 'a, 'a, 'a))
    }
  }

  test("test case original") {
    for (p15 <- createGenerators[Symbol]) {
      p15.duplicateN(3, List('a, 'b, 'c, 'c, 'd)) should be(List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
    }
  }
}