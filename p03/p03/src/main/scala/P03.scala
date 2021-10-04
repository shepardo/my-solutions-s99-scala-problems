package com.shepardo.p99

trait P03Interface[T] {
  def nth(idx: Int, l: List[T]) : Option[T]
}

class P03Mine[T] extends P03Interface[T] {
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

class P03Builtin[T] extends P03Interface[T] {
  // Trivial with builtins.
  def nth(idx: Int, l: List[T]): Option[T] =
    if (idx >= 0 && idx < l.length) Some(l(idx))
    else None
}

class P03Recursive[T] extends P03Interface[T] {
// Not that much harder without.
  def nth(n: Int, ls: List[T]): Option[T] = (n, ls) match {
    case (0, h :: _   ) => Some(h)
    case (n, _ :: tail) => nth(n - 1, tail)
    case (_, Nil      ) => None
  }
}