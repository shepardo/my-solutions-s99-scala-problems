package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P20[T] {

  def removeAt(pos: Int, l: List[T]) : (List[T], T) = {
    val lb = new ListBuffer[T]()
    doRemoveAt(pos, l, lb, 0)
  }

  private def doRemoveAt(pos: Int, l: List[T], lb: ListBuffer[T], currentPos: Int) : (List[T], T) = {
    l match {
      case xi :: Nil => 
        if (pos == currentPos) {
          (lb.toList, xi)
        } else {
          throw new IllegalArgumentException("'pos' not found")
        }
      case xi :: xs =>
        if (pos == currentPos) {
          lb.addAll(xs)
          (lb.toList, xi)
        } else {
          lb.addOne(xi)
          doRemoveAt(pos, xs, lb, currentPos + 1)
        }
      case _ =>
        throw new IllegalArgumentException("'l' not found")
    }
  }
}
