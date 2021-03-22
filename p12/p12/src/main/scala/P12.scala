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
