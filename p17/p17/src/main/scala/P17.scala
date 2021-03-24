package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P17[T] {
  def split(pos: Int, l: List[T]): (List[T], List[T]) = {
    val lb = new ListBuffer[T]()
    doSplit(pos, l, lb, 1)
  }

  private def doSplit(pos: Int, l: List[T], lb: ListBuffer[T], currentPos: Int): (List[T], List[T]) = {
    l match {
      case xi :: Nil =>
        if (currentPos <= pos) {
          lb.addOne(xi)
        }
        (lb.toList, List())
      case xi :: xs =>
        lb.addOne(xi)
        if (pos != currentPos) {
          doSplit(pos, xs, lb, currentPos + 1)
        } else {
          (lb.toList, xs)
        }
      case _ => (List(), List())
    }
  }
}