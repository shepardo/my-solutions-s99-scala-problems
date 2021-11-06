package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P06Test extends AnyFunSuite with Matchers {

  def createGenerators[T] = {
    val gens = Array(new P06Mine[T](), new P06Builtin[T]())
    for(x <- gens) yield x
  }

  test("that returns the palindrome of a single item list") {
    for (p06 <- createGenerators[Int]) {
      p06.isPalindrome(List(3)) should be(true)
    }
  }

  test("that returns the palindrome of an empty list") {
    for (p06 <- createGenerators[Int]) {
      p06.isPalindrome(List()) should be(true)
    }
  }

  test("that returns the reverse of a list with several items") {
    for (p06 <- createGenerators[Int]) {
      p06.isPalindrome(List(1, 2, 3, 2, 1)) should be(true)
    }
  }
}