package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P15[T] {

  def duplicateN(reps: Int, l: List[T]): List[T] = {
    val lb = new ListBuffer[T]()
    doDuplicateN(reps, l, lb)
    lb.toList
  }

  private def doDuplicateN(reps: Int, l: List[T], lb: ListBuffer[T]): Unit = {
    l match {
      case xi :: Nil =>
        lb.addAll(List.fill(reps)(xi))
      case xi :: xs =>
        lb.addAll(List.fill(reps)(xi))
        doDuplicateN(reps, xs, lb)
      case _ =>
    }
  }
}