package com.shepardo.p99

class P03[T] {
  def nth(idx: Int, l: List[T]) : Option[T] = {
      doNth(idx, l)
  }

  private def doNth(idx: Int, l : List[T]) : Option[T] = {
      l match {
          case x::Nil => 
            if (idx == 0) Some(x)
            else None 
          case x :: xs => 
            if (idx == 0) Some(x)
            else doNth(idx - 1, xs)
          case Nil => None
      }
  }
}