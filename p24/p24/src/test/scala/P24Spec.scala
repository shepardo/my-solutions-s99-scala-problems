package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P24Spec extends AnyFunSuite with Matchers {

  test ("empty list") {
    val p24 = new P24()
    val result = p24.lotto(0, 49)
    result should be(List())
  }

  test ("empty list 2") {
    val p24 = new P24()
    val result = p24.lotto(-10, 49)
    result should be(List())
  }

  test("original test case") {
    val p24 = new P24()
    val result = p24.lotto(6, 49)
    result.foreach(println)
    result should be(result)
  }
}