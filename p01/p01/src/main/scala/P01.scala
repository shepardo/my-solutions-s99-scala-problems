package com.shepardo.p99

trait P01Interface[T] {
  def last(l: List[T]) : Option[T]
}

// class P01[T >: Null] {
class P01Mine[T] extends P01Interface[T] {
  def last(l: List[T]) : Option[T] = {
      l match {
          case x::Nil => Some(x)
          case x :: xs => last(xs)
          case Nil => None
      }
  }
}


// P01 (*) Find the last element of a list.
//     Example:
//     scala> last(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 8

// The start of the definition of last should be
//     def last[A](l: List[A]): A = ...
// The `[A]` allows us to handle lists of any type.

class P01Builtin[T] extends P01Interface[T] {
  // There are several ways to solve this problem.  If we use builtins, it's very
  // easy.
  def last(ls: List[T]): Option[T] = if (!ls.isEmpty) Some(ls.last) else None
}

class P01Recursive[T] extends P01Interface[T] {
  // The standard functional approach is to recurse down the list until we hit
  // the end.  Scala's pattern matching makes this easy.
  def last(ls: List[T]): Option[T] = ls match {
    case h :: Nil  => Some(h)
    case _ :: tail => last(tail)
    case Nil => None
    case _         => throw new NoSuchElementException
  }
}
