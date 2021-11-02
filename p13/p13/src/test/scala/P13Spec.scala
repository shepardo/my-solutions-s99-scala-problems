package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P13Test extends AnyFunSuite with Matchers {

 def createGenerators[T] = { 
    val gens = Array(new P13Mine[T](), new P13Functional[T]())
    for( x <- gens) yield x
  }

  test("test original test case") {
    for (p13 <- createGenerators[Symbol]) {
      p13.encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should 
        be(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    }
  }

  test("test with empty list") {
    for (p13 <- createGenerators[Int]) {
      p13.encodeDirect(List()) should be(List())
    }
  }

  test("single number test case") {
    for (p13 <- createGenerators[Symbol]) {
      p13.encodeDirect(List('a, 'a, 'a, 'a, 'a, 'a, 'a)) should 
        be(List((7, 'a)))
    }
  }
}