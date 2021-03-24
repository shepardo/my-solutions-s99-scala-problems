package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P16Spec extends AnyFunSuite with Matchers {

  test("With empty list") {
    val p16 = new P16[Int]()
    p16.drop(3, List()) should be(List())
  }

  test("With single element list") {
    val p16 = new P16[Int]()
    p16.drop(4, List(1)) should be(List(1))
  }

  test("with single element list becoming empty") {
    val p16 = new P16[Int]()
    p16.drop(1, List(1)) should be(List())
  }

  test("with several items list and a skip 2 factor") {
    val p16 = new P16[Symbol]()
    p16.drop(2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(List('a, 'c, 'e, 'g, 'i, 'k))
  }

  test("with original test case") {
    val p16 = new P16[Symbol]()
    p16.drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }
}