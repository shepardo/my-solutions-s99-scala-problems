package com.shepard.p99

import scala.collection.mutable.ListBuffer

class P11[T] {

  def encodeModified(l: List[T]): List[Any] = {
    val lb = new ListBuffer[Any]
    doEncodeModified(l, lb, None, 0)
    lb.toList
  }

  private def doEncodeModified(l: List[T], lb: ListBuffer[Any], prev: Option[T], reps: Int): Unit = {
    l match {
      case xi :: Nil => 
        if (prev.isDefined) {
          if (prev.get != xi) {
            lb.addOne(if (reps == 1) prev.get else (reps, prev.get) )
            lb.addOne(xi)
          } else {
            lb.addOne((reps + 1, xi))
          }
        } else {
            lb.addOne(xi)
        }
      case xi :: xs =>
        if (prev.isDefined) {
          if (prev.get == xi) {
            doEncodeModified(xs, lb, prev, reps + 1)
          } else {
            lb.addOne(if (reps == 1) prev.get else (reps, prev.get))
            doEncodeModified(xs, lb, Some(xi), 1)
          }
        } else {
          doEncodeModified(xs, lb, Some(xi), 1)
        }
      case _ =>
    }
  }
}

object Main extends App {
  println("Hello, World!")
}