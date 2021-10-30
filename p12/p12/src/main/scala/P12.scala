package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P12[T] {

  def decode(l: List[Any]): List[T] = {
    val lb = ListBuffer[T]()
    doDecode(l, lb)
    lb.toList
  }

  private def doDecode(l: List[Any], lb: ListBuffer[T]): Unit = {
    l match {
      case xi :: Nil =>
        xi match {
          case t: (Int, T) => lb.addAll(List.fill(t._1)(t._2))
          case i : T => lb.addOne(i)
        }
      case xi :: xs => {
        xi match {
          case t: (Int, T) => lb.addAll(List.fill(t._1)(t._2))
          case i: T => lb.addOne(i)
        }
        doDecode(xs, lb)
      }
      case _ =>
    }
  }
}

// P12 (**) Decode a run-length encoded list.
//     Given a run-length code list generated as specified in problem P10,
//     construct its uncompressed version.
//
//     Example:
//     scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
//     res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

object P12 {
  def decode[A](ls: List[(Int, A)]): List[A] =
    ls flatMap { e => List.make(e._1, e._2) }
}
