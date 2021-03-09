package com.shepardo.p99

class P04[T] {
  def length(l: List[T]) : Int = {
      l match {
        case x :: Nil => 1
        case Nil => 0
        case _ => 1 + length(l.tail)
      }
  }
}