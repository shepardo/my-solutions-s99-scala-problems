package com.shepardo.p99

class P02[T] {
  def penultimate(l: List[T]) : Option[T] = {
      doPenultimate(l, None)
  }

  private def doPenultimate(l : List[T], penultimate: Option[T]) : Option[T] = {
      l match {
          case x::Nil => penultimate
          case x :: xs => doPenultimate(xs,Some(x))
          case Nil => penultimate
      }
  }
}