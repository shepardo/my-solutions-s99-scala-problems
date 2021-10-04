package com.shepardo.p99

trait P04Interface[T] {
  def length(l: List[T]) : Int
}

class P04Mine[T] extends P04Interface[T] {
  def length(l: List[T]) : Int = {
      l match {
        case x :: Nil => 1
        case Nil => 0
        case _ => 1 + length(l.tail)
      }
  }
}

// P04 (*) Find the number of elements of a list.
//     Example:
//     scala> length(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 6


class P04Builtin[T] extends P04Interface[T] {
  // Builtins.
  def length(ls: List[T]): Int = ls.length
}

class P04Recursive[T] extends P04Interface[T] {
  // Simple recursive solution.
  def length(ls: List[T]): Int = ls match {
    case Nil       => 0
    case _ :: tail => 1 + length(tail)
  }
}

class P04TailRecursive[T] extends P04Interface[T] {
// Tail recursive solution.  Theoretically more efficient; with tail-call
  // elimination in the compiler, this would run in constant space.
  // Unfortunately, the JVM doesn't do tail-call elimination in the general
  // case.  Scala *will* do it if the method is either final or is a local
  // function.  In this case, `lengthR` is a local function, so it should
  // be properly optimized.
  // For more information, see
  // http://blog.richdougherty.com/2009/04/tail-calls-tailrec-and-trampolines.html
  def length(ls: List[T]): Int = {
    def lengthR(result: Int, curList: List[T]): Int = curList match {
      case Nil       => result
      case _ :: tail => lengthR(result + 1, tail)
    }
    lengthR(0, ls)
  }
}

class P04Functional[T] extends P04Interface[T] {
  // More pure functional solution, with folds.
  def length(ls: List[T]): Int = ls.foldLeft(0) { (c, _) => c + 1 }
}
