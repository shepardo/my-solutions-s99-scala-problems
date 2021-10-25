package com.shepard.p99

import scala.collection.mutable.ListBuffer

class P11[T] {

  def encodeModified(l: List[T]): List[Any] = {
    val lb = new ListBuffer[Any]
    doEncodeModified(l, lb, None, 0)
    lb.toList
  }

  private def doEncodeModified(l: List[T], lb: ListBuffer[Any], prev: Option[T], reps: Int): Unit = {
    l match {
      case xi :: Nil => 
        if (prev.isDefined) {
          if (prev.get != xi) {
            lb.addOne(if (reps == 1) prev.get else (reps, prev.get) )
            lb.addOne(xi)
          } else {
            lb.addOne((reps + 1, xi))
          }
        } else {
            lb.addOne(xi)
        }
      case xi :: xs =>
        if (prev.isDefined) {
          if (prev.get == xi) {
            doEncodeModified(xs, lb, prev, reps + 1)
          } else {
            lb.addOne(if (reps == 1) prev.get else (reps, prev.get))
            doEncodeModified(xs, lb, Some(xi), 1)
          }
        } else {
          doEncodeModified(xs, lb, Some(xi), 1)
        }
      case _ =>
    }
  }
}

object Main extends App {
  println("Hello, World!")
}

// P11 (*) Modified run-length encoding.
//     Modify the result of problem P10 in such a way that if an element has no
//     duplicates it is simply copied into the result list.  Only elements with
//     duplicates are transferred as (N, E) terms.
//
//     Example:
//     scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

object P11 {
  import P10.encode
  def encodeModified[A](ls: List[A]): List[Any] =
    encode(ls) map { t => if (t._1 == 1) t._2 else t }

  // Just for fun, here's a more typesafe version.
  def encodeModified2[A](ls: List[A]): List[Either[A, (Int, A)]] =
    encode(ls) map { t => if (t._1 == 1) Left(t._2) else Right(t) }
}

