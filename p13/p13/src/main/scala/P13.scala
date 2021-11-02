package com.shepardo.p99

import scala.collection.mutable.ListBuffer

trait P013Interface[T] {
  def encodeDirect(ls: List[T]): List[(Int, T)]
}

class P13Mine[T] extends P013Interface[T] {

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


// P13 (**) Run-length encoding of a list (direct solution).
//     Implement the so-called run-length encoding data compression method
//     directly.  I.e. don't use other methods you've written (like P09's
//     pack); do all the work directly.
//
//     Example:
//     scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

class P13Functional[T] extends P013Interface[T] {
  // This is basically a modification of P09.
  def encodeDirect(ls: List[T]): List[(Int, T)] =
    if (ls.isEmpty) Nil
    else {
      val (packed, next) = ls span { _ == ls.head }
      (packed.length, packed.head) :: encodeDirect(next)
    }
}
