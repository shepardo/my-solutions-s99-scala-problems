package com.shepardo.p99

import scala.collection.mutable.ListBuffer
import scala.util.Random

class P23[T] {

  def randomSelect(nitems: Int, l: List[T]) : List[T] = {
    val lb = new ListBuffer[T]()
    val random_var = new Random
    value = list(random_var.nextInt(list.length))
  }

  private def doRandomSelect(pos: Int, l: List[T], lb: ListBuffer[T], currentPos: Int) : (List[T], T) = {
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
          doRandomSelect(pos, xs, lb, currentPos + 1)
        }
      case _ =>
        throw new IllegalArgumentException("'l' not found")
    }
  }
}
