package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class BalanceSpec extends AnyFunSuite with Matchers { 

  test("first case") {
    val balance = new Balance()
    balance.balance(List('(', '(', '(', ')', '(', ')', ')', ')')) should be(true)
  }

  test("counting not enough") {
    val balance = new Balance()
    balance.balance(List('(', ')', ')', '(')) should be(false)
  }
}
