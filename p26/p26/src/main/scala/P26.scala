package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P26[T] {

  def combinations(nitems: Int, l: List[T]): List[List[T]] = {
    if (nitems > l.length) return List(())
    val lbb = new ListBuffer[List[T]]()
    for (i <- 1 to nitems) {
      val lb = new ListBuffer[T]()
      var idx = 0
      val cnts = List.fill(nitems)(0)
      do {
        lb.addOne(l(cnts(idx)))
        idx = idx + 1 if idx < nitems - 1 else idx - 1
      } while (idx > 0 || cnts(0) < nitems)
      /*
      for (j <- 0 to nitems - 1) {
        lb.addOne(l(cnts(j)))
        cnts(j) = cnts(j) + 1
      }
      lbb.addOne(lb.toList)*/
    }
    lbb.toList
  }

  private def doCombinations(idx: Int) = {

  }
}
