package com.shepardo.p99

import scala.collection.mutable.ListBuffer

trait P05Interface[T] {
  def reverse(l: List[T]) : List[T]
}

class P05Mine[T] extends P05Interface[T] {
  def reverse(l: List[T]) : List[T] = {
      val lb = new ListBuffer[T]()
      doReverse(l, lb).toList
  }

  private def doReverse(l: List[T], lb: ListBuffer[T]) : ListBuffer[T] = {
    l match {
      case x :: Nil => lb :+ x
      case x :: xs => doReverse(xs, lb) :+ x
      case _ => lb
    }
  }
}

// P05 (*) Reverse a list.
//     Example:
//     scala> reverse(List(1, 1, 2, 3, 5, 8))
//     res0: List[Int] = List(8, 5, 3, 2, 1, 1)

class P05Builtin[T] extends P05Interface[T] {
  def reverse(ls: List[T]): List[T] = ls.reverse
}

class P05SimpleRecursive[T] extends P05Interface[T] {
  // Simple recursive.  O(n^2)
  def reverse(ls: List[T]): List[T] = ls match {
    case Nil       => Nil
    case h :: tail => reverse(tail) ::: List(h)
  }
}

class P05TailRecursive[T] extends P05Interface[T] {
  // Tail recursive.
  def reverse(ls: List[T]): List[T] = {
    def reverseR(result: List[T], curList: List[T]): List[T] = curList match {
      case Nil       => result
      case h :: tail => reverseR(h :: result, tail)
    }
    reverseR(Nil, ls)
  }
}

class P05PureFunctional[T] extends P05Interface[T] {
  // Pure functional
  def reverse(ls: List[T]): List[T] =
    ls.foldLeft(List[T]()) { (r, h) => h :: r }
}

