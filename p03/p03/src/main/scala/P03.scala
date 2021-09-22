package com.shepardo.p99

class P03[T] {
  def nth(idx: Int, l: List[T]) : Option[T] = {
      doNth(idx, l)
  }

  private def doNth(idx: Int, l : List[T]) : Option[T] = {
      l match {
          case x::Nil => 
            if (idx == 0) Some(x)
            else None 
          case x :: xs => 
            if (idx == 0) Some(x)
            else doNth(idx - 1, xs)
          case Nil => None
      }
  }
}

// P03 (*) Find the Kth element of a list.
//     By convention, the first element in the list is element 0.
//
//     Example:
//     scala> nth(2, List(1, 1, 2, 3, 5, 8))
//     res0: Int = 2

object P03 {
  // Trivial with builtins.
  def nthBuiltin[A](n: Int, ls: List[A]): A =
    if (n >= 0) ls(n)
    else throw new NoSuchElementException

  // Not that much harder without.
  def nthRecursive[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, h :: _   ) => h
    case (n, _ :: tail) => nthRecursive(n - 1, tail)
    case (_, Nil      ) => throw new NoSuchElementException
  }
}
