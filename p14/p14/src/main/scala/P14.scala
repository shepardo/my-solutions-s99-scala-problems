package com.shepardo.p99

import scala.collection.mutable.ListBuffer

trait P14Interface[T] {
  def duplicate(l: List[T]): List[T]
}

class P14Mine[T] extends P14Interface[T] {

  def duplicate(l: List[T]): List[T] = {
    val lb = new ListBuffer[T]()
    doDuplicate(l, lb)
    lb.toList
  }

  private def doDuplicate(l: List[T], lb: ListBuffer[T]): Unit = {
    l match {
      case xi :: Nil =>
        lb.addOne(xi)
        lb.addOne(xi)
      case xi :: xs =>
        lb.addOne(xi)
        lb.addOne(xi)
        doDuplicate(xs, lb)
      case _ =>
    }
  }
}

// P14 (*) Duplicate the elements of a list.
//     Example:
//     scala> duplicate(List('a, 'b, 'c, 'c, 'd))
//     res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

class P14Functional[T] extends P14Interface[T] {
  def duplicate(ls: List[T]): List[T] = ls flatMap { e => List(e, e) }
}

