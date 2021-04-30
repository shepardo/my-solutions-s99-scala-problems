package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P22 {

  def range(left: Int, right: Int) : List[Int] = {
    val lb = new ListBuffer[Int]()
    for (i <- left to right) {
      lb.addOne(i)
    }
    lb.toList
  }
}
