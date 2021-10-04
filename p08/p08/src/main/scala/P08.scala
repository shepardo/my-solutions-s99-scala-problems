package com.shepardo.p99

import scala.collection.mutable.ListBuffer
// postfix operator isDefined needs to be enabled by making the implicit value scala.language.postfixOps visible.
//import scala.language.postfixOps

class P08[T] {
  def compress(l: List[T]) : List[T] = {
    val lb = new ListBuffer[T]()
    doCompress(l, lb, None)
    lb.toList
  }

  def doCompress(l: List[T], lb: ListBuffer[T], prev: Option[T]): Unit = {
    l match {
      case xi :: Nil =>
        //println(s"case xi::Nil, xi=$xi")
        if (prev.isDefined) {
          if (prev.get != xi) {
            lb.addOne(prev.get)
          }
        }
        lb.addOne(xi)
      case xi :: xs =>
        if (prev.isDefined) {
          if (prev.get != xi) {
            lb.addOne(prev.get)
          }
        }
        doCompress(xs, lb, Some(xi))
      case _ => 
    }
  }
}

// P08 (**) Eliminate consecutive duplicates of list elements.
//     If a list contains repeated elements they should be replaced with a
//     single copy of the element.  The order of the elements should not be
//     changed.
//
//     Example:
//     scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)

object P08 {
  // Standard recursive.
  def compressRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil       => Nil
    case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
  }

  // Tail recursive.
  def compressTailRecursive[A](ls: List[A]): List[A] = {
    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil       => result.reverse
    }
    compressR(Nil, ls)
  }

  // Functional.
  def compressFunctional[A](ls: List[A]): List[A] =
    ls.foldRight(List[A]()) { (h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }
}
