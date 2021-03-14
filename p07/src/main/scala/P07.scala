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