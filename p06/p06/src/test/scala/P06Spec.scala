package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P06Test extends AnyFunSuite with Matchers {

  val p06 = new P06[Int]()

  test("that returns the palindrome of a single item list") {
    p06.isPalindrome(List(3)) should be(true)
  }

  test("that returns the palindrome of an empty list") {
    p06.isPalindrome(List()) should be(true)
  }

  test("that returns the reverse of a list with several items") {
    p06.isPalindrome(List(1, 2, 3, 2, 1)) should be(true)
  }
}