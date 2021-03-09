package com.shepardo.p99

// class P01[T >: Null] {
class P01[T] {
  def last(l: List[T]) : Option[T] = {
      l match {
          case x::Nil => Some(x)
          case x :: xs => last(xs)
          case Nil => None
      }
  }
}