package com.shepardo.p99

import scala.collection.mutable.ListBuffer

class P19[T] {

  def rotate(pos: Int, l: List[T]): List[T] = {
    val indexes = l.zipWithIndex;
    if (pos >= 0) {
      val lb1 = new ListBuffer[T]()
      val lb2 = new ListBuffer[T]()
      //indexes.filter( (idx, value) => if idx >= )
      //val (result1, result2) = indexes.partition( (idx, value) => if (idx >= pos) true else false)
      //val (result1, result2) = indexes.partition{ case (idx, value) => if (idx >= pos) true else false}
      indexes.foreach {
        case (value, idx) => {
          if (idx >= pos) {
            lb1.addOne(value)
          } else {
            lb2.addOne(value)
          }
        }
      }
      lb1.toList ::: lb2.toList
      //lb.addAll(result1.mapValues(x => x._2))
      //lb.addAll(result2.map(_._2))
    } else {
      val len  = l.length
      //val (result1, result2) = indexes.partition( (value, idx) => if (idx - len <= pos) false else true)
      val (result1, result2) = indexes.partition{ case (value, idx) => if ((idx - len + 1) <= pos) false else true}
      val lb = new ListBuffer[T]()
      lb.addAll(result1.map(_._1))
      lb.addAll(result2.map(_._1))
      lb.toList
    }
    //lb.toList
  }
}

// P19 (**) Rotate a list N places to the left.
//     Examples:
//     scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
//
//     scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

object P19 {
  def rotate[A](n: Int, ls: List[A]): List[A] = {
    val nBounded = if (ls.isEmpty) 0 else n % ls.length
    if (nBounded < 0) rotate(nBounded + ls.length, ls)
    else (ls drop nBounded) ::: (ls take nBounded)
  }
}
