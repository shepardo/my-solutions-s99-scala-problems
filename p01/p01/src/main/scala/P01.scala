package com.shepardo.p99

trait P01Interface[T] {
  def last(l: List[T]) : Option[T]
}

// class P01[T >: Null] {
class P01[T] extends P01Interface[T] {
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

object P01 {
  // There are several ways to solve this problem.  If we use builtins, it's very
  // easy.
  def lastBuiltin[A](ls: List[A]): A = ls.last

  // The standard functional approach is to recurse down the list until we hit
  // the end.  Scala's pattern matching makes this easy.
  def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil  => h
    case _ :: tail => lastRecursive(tail)
    case _         => throw new NoSuchElementException
  }
}
