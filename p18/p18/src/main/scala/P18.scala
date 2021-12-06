
package com.shepardo.p99

import scala.collection.mutable.ListBuffer

trait P18Interface[T] {
  def slice(left: Int, right: Int, l: List[T]): List[T]
}

class P18Mine[T] extends P18Interface[T] {
  def slice(left: Int, right: Int, l: List[T]): List[T] = {
    val lb = new ListBuffer[T]()
    doSlice(left, right, l, lb, 0)
    lb.toList
  }

  private def doSlice(left: Int, right: Int, l: List[T], lb: ListBuffer[T], pos: Int): Unit = {
    l match {
      case xi :: Nil =>
        if (pos >= left && pos < right) {
          lb.addOne(xi)
        }
      case xi :: xs =>
        if (pos >= left && pos < right) {
          lb.addOne(xi)
        }
        doSlice(left, right, xs, lb, pos + 1)
      case _ =>
    }
  }
}

// P18 (**) Extract a slice from a list.
//     Given two indices, I and K, the slice is the list containing the elements
//     from and including the Ith element up to but not including the Kth
//     element of the original list.  Start counting the elements with 0.
//
//     Example:
//     scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('d, 'e, 'f, 'g)

class P18Builtin[T] extends P18Interface[T] {
  // Builtin.
  def slice(start: Int, end: Int, ls: List[T]): List[T] =
    ls.slice(start, end)
}

class P18Recursive[T] extends P18Interface[T] {
  // Simple recursive.
  def slice(start: Int, end: Int, ls: List[T]): List[T] =
    (start, end, ls) match {
      case (_, _, Nil)                 => Nil
      case (_, e, _)         if e <= 0 => Nil
      case (s, e, h :: tail) if s <= 0 => h :: sliceRecursive(0, e - 1, tail)
      case (s, e, h :: tail)           => sliceRecursive(s - 1, e - 1, tail)
    }
}

object P18 {

  
  // Tail recursive, using pattern matching.
  def sliceTailRecursive[A](start: Int, end: Int, ls: List[A]): List[A] = {
    def sliceR(count: Int, curList: List[A], result: List[A]): List[A] =
      (count, curList) match {
        case (_, Nil)                     => result.reverse
        case (c, h :: tail) if end <= c   => result.reverse
        case (c, h :: tail) if start <= c => sliceR(c + 1, tail, h :: result)
        case (c, _ :: tail)               => sliceR(c + 1, tail, result)
      }
    sliceR(0, ls, Nil)
  }

  // Since several of the patterns are similar, we can condense the tail recursive
  // solution a little.
  def sliceTailRecursive2[A](start: Int, end: Int, ls: List[A]): List[A] = {
    def sliceR(count: Int, curList: List[A], result: List[A]): List[A] = {
      if (curList.isEmpty || count >= end) result.reverse
      else sliceR(count + 1, curList.tail,
                  if (count >= start) curList.head :: result
                  else result)
    }
    sliceR(0, ls, Nil)
  }

  // Functional.
  def sliceFunctional[A](s: Int, e: Int, ls: List[A]): List[A] =
    ls drop s take (e - (s max 0))
}
