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
        lb.toList
      case xi :: xs =>
        if (pos == targetPos) {
          lb.addOne(elem)
        }
        lb.addOne(xi)
        doInsertAt(elem, pos + 1, targetPos, xs, lb)
      case _ =>
        throw new IllegalArgumentException("'l' not found")
    }
  }
}