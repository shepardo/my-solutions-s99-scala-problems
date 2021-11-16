package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P20[T] {

  def removeAt(pos: Int, l: List[T]) : (List[T], T) = {
    val lb = new ListBuffer[T]()
    doRemoveAt(pos, l, lb, 0)
  }

  private def doRemoveAt(pos: Int, l: List[T], lb: ListBuffer[T], currentPos: Int) : (List[T], T) = {
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
          doRemoveAt(pos, xs, lb, currentPos + 1)
        }
      case _ =>
        throw new IllegalArgumentException("'l' not found")
    }
  }
}

// P20 (*) Remove the Kth element from a list.
//     Return the list and the removed element in a Tuple.  Elements are
//     numbered from 0.
//
//     Example:
//     scala> removeAt(1, List('a, 'b, 'c, 'd))
//     res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

object P20 {
  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post)  => (pre ::: post, e)
    case (pre, Nil)        => throw new NoSuchElementException
  }

  // Alternate, with fewer builtins.
  def removeAt2[A](n: Int, ls: List[A]): (List[A], A) =
    if (n < 0) throw new NoSuchElementException
    else (n, ls) match {
      case (_, Nil) => throw new NoSuchElementException
      case (0, h :: tail) => (tail, h)
      case (_, h :: tail) => {
        val (t, e) = removeAt(n - 1, ls.tail)
        (ls.head :: t, e)
      }
    }
}
