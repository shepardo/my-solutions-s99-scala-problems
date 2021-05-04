package com.shepardo.p99

import scala.collection.mutable.ListBuffer
import scala.util.Random

class P24 {

  def lotto(ntimes: Int, max: Int): List[Int] = {
    val lb = new ListBuffer[Int]()
    val random_var = new Random
    var i = 0
    while (i < ntimes) {
      lb.addOne(random_var.nextInt(max))
      i += 1
    }
    lb.toList
  }
}