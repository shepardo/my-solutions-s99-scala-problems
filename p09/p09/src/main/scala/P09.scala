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

// P09 (**) Pack consecutive duplicates of list elements into sublists.
//     If a list contains repeated elements they should be placed in separate
//     sublists.
//
//     Example:
//     scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

object P09 {
  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }
}
