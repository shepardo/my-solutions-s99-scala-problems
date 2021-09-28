package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P07[T] {
  def flatten(l: List[Any]) : List[Any] = {
    val lb = new ListBuffer[Any]()
    doFlatten(l, lb).toList
  }

  private def doFlatten(l: List[Any], lb: ListBuffer[Any]) : ListBuffer[Any] = {
    l.foreach( x => {
      x match {
        case xi :: xs =>
          lb.addOne(xi)
          doFlatten(xs, lb)
        case _ =>
          lb.addOne(x)
      }} )
    lb
  }

}

// P07 (**) Flatten a nested list structure.
//     Example:
//     scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
//     res0: List[Any] = List(1, 1, 2, 3, 5, 8)

object P07 {
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }
}
