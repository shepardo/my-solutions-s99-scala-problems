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


// P06 (*) Find out whether a list is a palindrome.
//     Example:
//     scala> isPalindrome(List(1, 2, 3, 2, 1))
//     res0: Boolean = true

object P06 {
  // In theory, we could be slightly more efficient than this.  This approach
  // traverses the list twice: once to reverse it, and once to check equality.
  // Technically, we only need to check the first half of the list for equality
  // with the first half of the reversed list.  The code to do that more
  // efficiently than this implementation is much more complicated, so we'll
  // leave things with this clear and concise implementation.
  def isPalindrome[A](ls: List[A]): Boolean = ls == ls.reverse
}

