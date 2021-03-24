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