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

// P10 (*) Run-length encoding of a list.
//     Use the result of problem P09 to implement the so-called run-length
//     encoding data compression method.  Consecutive duplicates of elements are
//     encoded as tuples (N, E) where N is the number of duplicates of the
//     element E.
//
//     Example:
//     scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

object P10 {
  import P09.pack
  def encode[A](ls: List[A]): List[(Int, A)] =
    pack(ls) map { e => (e.length, e.head) }
}
