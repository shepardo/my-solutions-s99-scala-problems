package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P21[T] {

  def insertAt(elem: T, pos: Int, l: List[T]): List[T] = {
    val lb = new ListBuffer[T]()
    doInsertAt(elem, 0, pos, l, lb)
  }

  private def doInsertAt(elem: T, pos: Int, targetPos: Int, l: List[T], lb: ListBuffer[T]): List[T] = {
    l match {
      case xi :: Nil =>
        if (pos == targetPos) {
          lb.addOne(elem)
        }
        lb.addOne(xi)
        if (pos < targetPos) {
          lb.addOne(elem)
        }
        lb.toList
      case xi :: xs =>
        if (pos == targetPos) {
          lb.addOne(elem)
        }
        lb.addOne(xi)
        doInsertAt(elem, pos + 1, targetPos, xs, lb)
      case Nil =>
        List()
      case _ =>
        throw new IllegalArgumentException("'l' not found")
    }
  }
}

// P21 (*) Insert an element at a given position into a list.
//     Example:
//     scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
//     res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

object P21 {
  def insertAt[A](e: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match {
    case (pre, post) => pre ::: e :: post
  }
}
