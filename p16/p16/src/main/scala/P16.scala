package com.shepardo.p99

import scala.collection.mutable.ListBuffer

trait P16Interface[T] {
  def drop(nth: Int, l: List[T]): List[T]
}

class P16Mine[T] extends P16Interface[T] {

  def drop(nth: Int, l: List[T]): List[T] = {
    val lb = new ListBuffer[T]()
    doDrop(nth, l, lb, 1)
    lb.toList
  }

  private def doDrop(nth: Int, l: List[T], lb: ListBuffer[T], pos: Int): Unit = {
    l match {
      case xi :: Nil =>
        if (pos % nth != 0) {
          lb.addOne(xi)
        }
      case xi :: xs =>
        if (pos % nth != 0) {
          lb.addOne(xi)
        }
        doDrop(nth, xs, lb, pos + 1)
      case _ =>
    }
  }
}

// P16 (**) Drop every Nth element from a list.
//     Example:
//     scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

class P16Recursive[T] extends P16Interface[T] {
  // Simple recursion.
  def drop(nth: Int, l: List[T]): List[T] = {
    def dropR(c: Int, curList: List[T]): List[T] = (c, curList) match {
      case (_, Nil)       => Nil
      case (1, _ :: tail) => dropR(nth, tail)
      case (_, h :: tail) => h :: dropR(c - 1, tail)
    }
    dropR(nth, l)
  }
}

class P16TailRecursive[T] extends P16Interface[T] {
  // Tail recursive.
  def drop(nth: Int, l: List[T]): List[T] = {
    def dropR(c: Int, curList: List[T], result: List[T]): List[T] = (c, curList) match {
      case (_, Nil)       => result.reverse
      case (1, _ :: tail) => dropR(nth, tail, result)
      case (_, h :: tail) => dropR(c - 1, tail, h :: result)
    }
    dropR(nth, l, Nil)
  }
}

class P16TFunctional[T] extends P16Interface[T] {
  // Functional
  def drop(nth: Int, l: List[T]): List[T] = {
    l.zipWithIndex filter { v => (v._2 + 1) % nth != 0 } map { _._1 }
  }
}
