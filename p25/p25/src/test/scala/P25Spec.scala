package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P25Spec extends AnyFunSuite with Matchers {
  
  test("original test case") {
    val p25 = new P25[Symbol]()
    val result = p25.randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
    result.foreach(println)
  }
}