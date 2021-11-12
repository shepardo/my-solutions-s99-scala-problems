package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P16[T] {

  def drop(nth: Int, l: List[T]): List[T] = {
    val lb = new ListBuffer[T]()
    doDrop(nth, l, lb, 1)
    lb.toList
  }

  private def doDrop(nth: Int, l: List[T], lb: ListBuffer[T], pos: Int): Unit = {
    l match {
      case xi :: Nil =>
        if (pos % nth != 0) {
          lb.addOne(xi)
        }
      case xi :: xs =>
        if (pos % nth != 0) {
          lb.addOne(xi)
        }
        doDrop(nth, xs, lb, pos + 1)
      case _ =>
    }
  }
}

// P16 (**) Drop every Nth element from a list.
//     Example:
//     scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

object P16 {
  // Simple recursion.
  def dropRecursive[A](n: Int, ls: List[A]): List[A] = {
    def dropR(c: Int, curList: List[A]): List[A] = (c, curList) match {
      case (_, Nil)       => Nil
      case (1, _ :: tail) => dropR(n, tail)
      case (_, h :: tail) => h :: dropR(c - 1, tail)
    }
    dropR(n, ls)
  }

  // Tail recursive.
  def dropTailRecursive[A](n: Int, ls: List[A]): List[A] = {
    def dropR(c: Int, curList: List[A], result: List[A]): List[A] = (c, curList) match {
      case (_, Nil)       => result.reverse
      case (1, _ :: tail) => dropR(n, tail, result)
      case (_, h :: tail) => dropR(c - 1, tail, h :: result)
    }
    dropR(n, ls, Nil)
  }

  // Functional.
  def dropFunctional[A](n: Int, ls: List[A]): List[A] = 
    ls.zipWithIndex filter { v => (v._2 + 1) % n != 0 } map { _._1 }
}
