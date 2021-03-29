
package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P18[T] {
  def slice(left: Int, right: Int, l: List[T]): List[T] = {
    val lb = new ListBuffer[T]()
    doSlice(left, right, l, lb, 0)
    lb.toList
  }

  private def doSlice(left: Int, right: Int, l: List[T], lb: ListBuffer[T], pos: Int): Unit = {
    l match {
      case xi :: Nil =>
        if (pos >= left && pos < right) {
          lb.addOne(xi)
        }
      case xi :: xs =>
        if (pos >= left && pos < right) {
          lb.addOne(xi)
        }
        doSlice(left, right, xs, lb, pos + 1)
      case _ =>
    }
  }
}

object Main extends App {
  println("Hello, World!")
}