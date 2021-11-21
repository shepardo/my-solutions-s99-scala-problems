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

// P23 (**) Extract a given number of randomly selected elements from a list.
//     Example:
//     scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
//     res0: List[Symbol] = List('e, 'd, 'a)
//
//     Hint: Use the answer to P20.

object P23 {
  import P20.removeAt

  def randomSelect1[A](n: Int, ls: List[A]): List[A] =
    if (n <= 0) Nil
    else {
      val (rest, e) = removeAt((new util.Random).nextInt(ls.length), ls)
      e :: randomSelect1(n - 1, rest)
    }

  // It can be expensive to create a new Random instance every time, so let's
  // only do it once.
  def randomSelect[A](n: Int, ls: List[A]): List[A] = {
    def randomSelectR(n: Int, ls: List[A], r: util.Random): List[A] =
      if (n <= 0) Nil
      else {
        val (rest, e) = removeAt(r.nextInt(ls.length), ls)
        e :: randomSelectR(n - 1, rest, r)
      }
    randomSelectR(n, ls, new util.Random)
  }
}

