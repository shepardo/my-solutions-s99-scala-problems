package com.shepardo.p99

import scala.collection.mutable.ListBuffer

trait P17Interface[T] {
  def split(pos: Int, l: List[T]): (List[T], List[T])
}

class P17Mine[T] extends P17Interface[T] {
  def split(pos: Int, l: List[T]): (List[T], List[T]) = {
    val lb = new ListBuffer[T]()
    doSplit(pos, l, lb, 1)
  }

  private def doSplit(pos: Int, l: List[T], lb: ListBuffer[T], currentPos: Int): (List[T], List[T]) = {
    l match {
      case xi :: Nil =>
        if (currentPos <= pos) {
          lb.addOne(xi)
        }
        (lb.toList, List())
      case xi :: xs =>
        lb.addOne(xi)
        if (pos != currentPos) {
          doSplit(pos, xs, lb, currentPos + 1)
        } else {
          (lb.toList, xs)
        }
      case _ => (List(), List())
    }
  }
}

// P17 (*) Split a list into two parts.
//     The length of the first part is given.  Use a Tuple for your result.
//
//     Example:
//     scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

class P17Builtin[T] extends P17Interface[T] {
  // Builtin.
  def split(pos: Int, l: List[T]): (List[T], List[T]) = l.splitAt(pos)
}

class P17Recursive[T] extends P17Interface[T] {
  // Simple recursion.
  def split(pos: Int, l: List[T]): (List[T], List[T]) = (pos, l) match {
    case (_, Nil)       => (Nil, Nil)
    case (0, list)      => (Nil, list)
    case (pos, h :: tail) => {
      val (pre, post) = split(pos - 1, tail)
      (h :: pre, post)
    }
  }
}

class P17TailRecurisve[T] extends P17Interface[T] {
  // Tail recursive.
  def split(pos: Int, l: List[T]): (List[T], List[T]) = {
    def splitR(curN: Int, curL: List[T], pre: List[T]): (List[T], List[T]) =
      (curN, curL) match {
        case (_, Nil)       => (pre.reverse, Nil)
        case (0, list)      => (pre.reverse, list)
        case (pos, h :: tail) => splitR(pos - 1, tail, h :: pre)
      }
    splitR(pos, l, Nil)
  }
}

class P17Functional[T] extends P17Interface[T] {
  // Functional (barely not "builtin").
  def split(pos: Int, l: List[T]): (List[T], List[T]) =
    (l.take(pos), l.drop(pos))
}
