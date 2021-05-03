package com.shepardo.p99

import scala.collection.mutable.ListBuffer
import scala.util.Random

class P23[T] {

  def randomSelect(nitems: Int, l: List[T]) : List[T] = {
    val lb = new ListBuffer[T]()
    val random_var = new Random
    val p20 = new P20[T]()
    var cnt = 0
    var tl = l
    while (cnt < nitems && tl.length > 0) {
      val pos: Int = random_var.nextInt(tl.length)
      lb.addOne(tl(pos))
      val result = p20.removeAt(pos, tl)
      tl = result._1
      cnt += 1
    }
    lb.toList
  }
}

class P20[T] {

  def removeAt(pos: Int, l: List[T]) : (List[T], T) = {
    val lb = new ListBuffer[T]()
    doRemoveAt(pos, l, lb, 0)
  }

  private def doRemoveAt(pos: Int, l: List[T], lb: ListBuffer[T], currentPos: Int) : (List[T], T) = {
    l match {
      case xi :: Nil => 
        if (pos == currentPos) {
          (lb.toList, xi)
        } else {
          throw new IllegalArgumentException("'pos' not found")
        }
      case xi :: xs =>
        if (pos == currentPos) {
          lb.addAll(xs)
          (lb.toList, xi)
        } else {
          lb.addOne(xi)
          doRemoveAt(pos, xs, lb, currentPos + 1)
        }
      case _ =>
        throw new IllegalArgumentException("'l' not found")
    }
  }
}

/*
  private def doRandomSelect(pos: Int, l: List[T], lb: ListBuffer[T], currentPos: Int) : (List[T], T) = {
    l match {
      case xi :: Nil => 
        if (pos == currentPos) {
          (lb.toList, xi)
        } else {
          throw new IllegalArgumentException("'pos' not found")
        }
      case xi :: xs =>
        if (pos == currentPos) {
          lb.addAll(xs)
          (lb.toList, xi)
        } else {
          lb.addOne(xi)
          doRandomSelect(pos, xs, lb, currentPos + 1)
        }
      case _ =>
        throw new IllegalArgumentException("'l' not found")
    }
  }*/

