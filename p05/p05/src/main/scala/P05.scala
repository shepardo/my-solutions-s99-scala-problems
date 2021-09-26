package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P05[T] {
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

object P05 {
  // Builtin.
  def reverseBuiltin[A](ls: List[A]): List[A] = ls.reverse

  // Simple recursive.  O(n^2)
  def reverseRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil       => Nil
    case h :: tail => reverseRecursive(tail) ::: List(h)
  }

  // Tail recursive.
  def reverseTailRecursive[A](ls: List[A]): List[A] = {
    def reverseR(result: List[A], curList: List[A]): List[A] = curList match {
      case Nil       => result
      case h :: tail => reverseR(h :: result, tail)
    }
    reverseR(Nil, ls)
  }

  // Pure functional
  def reverseFunctional[A](ls: List[A]): List[A] =
    ls.foldLeft(List[A]()) { (r, h) => h :: r }
}
