package com.shepardo.p99

class P06[T] {
  def isPalindrome(l: List[T]) : Boolean = {
    l match {
      case x :: Nil => true
      case Nil => true
      case x :: xs =>
        val init :+ last = xs
        if (last != x)
          false
        else
          isPalindrome(init)
    }
      //val lb = new ListBuffer[T]()
      //doReverse(l, lb).toList
  }

/*
  private def doReverse(l: List[T], lb: ListBuffer[T]) : ListBuffer[T] = {
    l match {
      case x :: Nil => lb :+ x
      case x :: xs => doReverse(xs, lb) :+ x
      case _ => lb
    }
  }*/
}