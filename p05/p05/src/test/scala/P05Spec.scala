package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P05Test extends AnyFunSuite with Matchers {

  def createGenerators[T] = {
    val gens = Array(new P05Mine[T](), new P05Builtin[T](), new P05SimpleRecursive[T](), new P05TailRecursive[T](), new P05PureFunctional[T]())
    for(x <- gens) yield x
  }

  test("that returns the reverse of a single item list") {
    for (p05 <- createGenerators[Int]) {
      p05.reverse(List(3)) should equal(List(3))
    }
  }

  test("that returns the reverse of an empty list") {
    for (p05 <- createGenerators[Int]) {
      p05.reverse(List()) should be(Nil)
    }
  }

  test("that returns the reverse of a list with several items") {
    for (p05 <- createGenerators[Int]) {
      p05.reverse(List(1, 1, 2, 3, 5, 8)) should be(List(8, 5, 3, 2, 1, 1))
    }
  }
}