package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P09Test extends AnyFunSuite with Matchers {

  
  test("that returns the pack of a single item list") {
    val p09 = new P09[Int]()
    p09.pack(List(3)) should be(List(List(3)))
  }

  test("that returns the pack of an empty list") {
    val p09 = new P09[Int]()
    p09.pack(List()) should be(List())
  }

  test("that returns the pack of a list with several items") {
    val p09 = new P09[Symbol]()
    p09.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should 
      be(List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }
}