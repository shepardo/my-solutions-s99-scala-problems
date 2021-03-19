package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P09[T] {

  def pack(l: List[T]): List[List[T]] = {
    val lb = new ListBuffer[List[T]]()
    doPack(l, lb, None, 0)
    lb.toList
  }

  private def doPack(l: List[T], lb: ListBuffer[List[T]], prev: Option[T], reps: Int): Unit = {
    l match {
      case xi :: Nil =>
        if (prev.isDefined) {
          if (prev.get != xi) {
            lb.addOne(List.fill(reps)(prev.get))
            lb.addOne(List(xi))
          } else {
            lb.addOne(List.fill(reps + 1)(xi))
          }
        } else {
          lb.addOne(List(xi))
        }
      case xi :: xs =>
        if (prev.isDefined) {
          if (prev.get != xi) {
            lb.addOne(List.fill(reps)(prev.get))
            doPack(xs, lb, Some(xi), 1)
          } else {
            doPack(xs, lb, prev, reps + 1)
          }
        } else {
          doPack(xs, lb, Some(xi), 1)
        }
      case _ =>
    }
  }
}