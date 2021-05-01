package com.shepardo.p99

import scala.collection.mutable.Stack

class Balance {

  def balance(l: List[Char]): Boolean = {
    var s = Stack[Char]()
    doBalance(l, s)
  }

  def doBalance(l: List[Char], s: Stack[Char]) : Boolean = {
    l match {
      case xi :: Nil =>
        if (xi == '(') {
          s.push(')')
          false
        } else if (s.isEmpty || s.pop != xi) {
            false
        } else {
            if (s.isEmpty ) { true }
            else { false }
        }
      case xi :: xs =>
        if (xi == '(') {
          s.push(')')
          doBalance(xs, s)
        } else if (s.isEmpty || s.pop != xi) {
          false
        } else {
          doBalance(xs, s)
        }
      case _ => false
    }
  }
}
