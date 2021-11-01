package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P13[T] {

  def encodeDirect(ls: List[T]): List[(Int, T)] = {
    val lb = ListBuffer[(Int, T)]()
    doEncodeDirect(ls, lb, None, 0)
    lb.toList
  }

  private def doEncodeDirect(l: List[T], lb: ListBuffer[(Int, T)], prev: Option[T], repeats: Int): Unit = {
    l match {
      case xi :: Nil =>
        if (prev.isDefined) {
          if (prev.get != xi) {
            lb.addOne((repeats, prev.get))
            lb.addOne((1, xi))
          } else {
            lb.addOne((repeats + 1, xi))  
          }
        } else {
          lb.addOne((1, xi))
        }
      case xi :: xs =>
        if (prev.isDefined) {
          if (prev.get != xi) {
            lb.addOne((repeats, prev.get))
            doEncodeDirect(xs, lb, Some(xi), 1)
          } else {
            doEncodeDirect(xs, lb, Some(xi), repeats + 1)
          }
        } else {
          doEncodeDirect(xs, lb, Some(xi), 1)
        }
      case _ =>
    }
  }
}