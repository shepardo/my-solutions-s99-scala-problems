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

// P24 (*) Lotto: Draw N different random numbers from the set 1..M.
//     Example:
//     scala> lotto(6, 49)
//     res0: List[Int] = List(23, 1, 17, 33, 21, 37)

object P24 {
  import P23.randomSelect
  def lotto(count: Int, max: Int): List[Int] = 
    randomSelect(count, List.range(1, max + 1))
}
