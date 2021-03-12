package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P05[T] {
  def reverse(l: List[T]) : List[T] = {
      val lb = new ListBuffer[T]()
      doReverse(l, lb).toList
  }

  private def doReverse(l: List[T], lb: ListBuffer[T]) : ListBuffer[T] = {
    l match {
      case x :: Nil => lb :+ x
      case x :: xs => doReverse(xs, lb) :+ x
      case _ => lb
    }
  }
}