package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P17Spec extends AnyFunSuite with Matchers {

  def createGenerators[T] = {
    val gens = Array(new P17Mine[T](), new P17Builtin[T](), new P17Recursive[T](), new P17TailRecurisve[T](), new P17Functional[T]())
    for(x <- gens) yield x
  }

  test("with empty list") {
    for (p17 <- createGenerators[Int]) {
      p17.split(3, List()) should be(List(), List())
    }
  }

  test("with 1 element list") {
    for (p17 <- createGenerators[Int]) {
      p17.split(3, List(1)) should be(List(1), List())
    }
  }

  test("with items in firs result") {
    for (p17 <- createGenerators[Int]) {
      p17.split(5, List(1, 2, 3, 4, 5)) should be((List(1, 2, 3, 4, 5), List()))
    }
  }

  test("with all but one element in first result") {
    for (p17 <- createGenerators[Int]) {
      p17.split(4, List(1, 2, 3, 4, 5)) should be((List(1, 2, 3, 4), List(5)))
    }
  }

  test("with original test case") {
    for (p17 <- createGenerators[Symbol]) {
      p17.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should 
        be((List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    }
  }
}