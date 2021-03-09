package com.shepardo.p99

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

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