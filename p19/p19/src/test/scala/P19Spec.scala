package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P19Spec extends AnyFunSuite with Matchers {

  test("empty list") {
    val p19 = new P19[Int]()
    p19.rotate(3, List()) should be (List())
  }

  test("empty list 2nd") {
    val p19 = new P19[Int]()
    p19.rotate(-4, List()) should be(List())
  }

  test("List with single element") {
    val p19 = new P19[Int]()
    p19.rotate(5, List(1)) should be(List(1))
  }

  test("List with single element 2nd") {
    val p19 = new P19[Int]()
    p19.rotate(-7, List(3)) should be(List(3))
  }

  test("original test case") {
    val p19 = new P19[Symbol]()
    p19.rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
  }

  test("original test case 2nd") {
    val p19 = new P19[Symbol]()
    p19.rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
  }
}