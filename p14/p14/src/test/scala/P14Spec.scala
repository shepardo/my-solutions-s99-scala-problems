package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P14Spec extends AnyFunSuite with Matchers {

  def createGenerators[T] = {
    val gens = Array(new P14Mine[T](), new P14Functional[T]())
    for(x <- gens) yield x
  }

  test("test empty list") {
    for (p14 <- createGenerators[Int]) {
      p14.duplicate(List()) should be(List())
    }
  }

  test("test with 1 element list") {
    for (p14 <- createGenerators[Int]) {
      p14.duplicate(List(1)) should be(List(1, 1))
    }
  }

  test("test original case") {
    for (p14 <- createGenerators[Symbol]) {
      p14.duplicate(List('a, 'b, 'c, 'c, 'd)) should be(List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
    }
  }
}