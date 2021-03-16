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