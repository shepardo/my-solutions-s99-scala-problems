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

// P15 (**) Duplicate the elements of a list a given number of times.
//     Example:
//     scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
//     res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

object P15 {
  def duplicateN[A](n: Int, ls: List[A]): List[A] =
    ls flatMap { List.make(n, _) }
}
