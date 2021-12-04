package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P18Spec extends AnyFunSuite with Matchers {

  def createGenerators[T] = {
    val gens = Array(new P18Mine[T]())
    for(x <- gens) yield x
  }

  test("with empty list test case") {
    for (p18 <- createGenerators[Int]) {
      p18.slice(3, 7, List()) should be(List())
    }
  }

  test("with single element list test case") {
    for (p18 <- createGenerators[Int]) {
      p18.slice(0, 7, List(2)) should be(List(2))
    }
  }

  test("with single element list test case 2nd") {
    for (p18 <- createGenerators[Int]) {
      p18.slice(3, 7, List(2)) should be(List())
    }
  }

  test("original test case") {
    for (p18 <- createGenerators[Symbol]) {
      p18.slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(List('d, 'e, 'f, 'g))
    }
  }

  test("variation on original test case 2nd") {
    for (p18 <- createGenerators[Symbol]) {
      p18.slice(4, 6, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(List('e, 'f))
    }
  }
}