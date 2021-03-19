package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P10[T] {

  def encode(l: List[T]): List[(Int, T)] = {
    val lb = new ListBuffer[(Int, T)]()
    doEncode(l, lb, None, 0)
    lb.toList
  }

  private def doEncode(l: List[T], lb: ListBuffer[(Int, T)], prev: Option[T], reps: Int) : Unit = {
    l match {
      case xi :: Nil =>
        if (prev.isDefined) {
          if (prev.get == xi) {
            lb.addOne((reps + 1, xi))
          } else {
            lb.addOne((reps, prev.get))
            lb.addOne((1, xi))  
          }
        } else {
          lb.addOne((1, xi))
        }
      case xi :: xs =>
        if (prev.isDefined) {
          if (prev.get == xi) {
            doEncode(xs, lb, prev, reps + 1)
          } else {
            lb.addOne((reps, prev.get))
            doEncode(xs, lb, Some(xi), 1)
          }
        } else {
          doEncode(xs, lb, Some(xi), 1)
        }
      case _ =>
    }
  }
}