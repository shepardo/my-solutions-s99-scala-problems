package com.shepardo.p99

trait P02Interface[T] {
  def penultimate(l: List[T]) : Option[T]
}

class P02Mine[T] extends P02Interface[T] {
  def penultimate(l: List[T]) : Option[T] = {
      doPenultimate(l, None)
  }

  private def doPenultimate(l : List[T], penultimate: Option[T]) : Option[T] = {
      l match {
          case x::Nil => penultimate
          case x :: xs => doPenultimate(xs,Some(x))
          case Nil => penultimate
      }
  }
}

class P02PenultimateBuiltin[T] extends P02Interface[T] {
  // Again, with builtins this is easy.
  def penultimate(ls: List[T]): Option[T] =
    if (ls.isEmpty) None
    else if (ls.init.isEmpty) None
    else Some(ls.init.last)
}

class P02PenultimateRecursive[T] extends P02Interface[T] {
    def penultimate(ls: List[T]): Option[T] = ls match {
    case h :: _ :: Nil => Some(h)
    case _ :: tail     => penultimate(tail)
    case _             => None
  }
}

// P02 (*) Find the last but one element of a list.
//     Example:
//     scala> penultimate(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 5

object P02 {


  // But pattern matching also makes it easy.
  def penultimateRecursive[A](ls: List[A]): A = ls match {
    case h :: _ :: Nil => h
    case _ :: tail     => penultimateRecursive(tail)
    case _             => throw new NoSuchElementException
  }
  
  

  // Just for fun, let's look at making a generic lastNth function.

  // An obvious modification of the builtin solution works.
  def lastNthBuiltin[A](n: Int, ls: List[A]): A = {
    if (n <= 0) throw new IllegalArgumentException
    if (ls.length < n) throw new NoSuchElementException
    ls.takeRight(n).head
  }

  // Here's one approach to a non-builtin solution.
  def lastNthRecursive[A](n: Int, ls: List[A]): A = {
    def lastNthR(count: Int, resultList: List[A], curList: List[A]): A =
      curList match {
        case Nil if count > 0 => throw new NoSuchElementException
        case Nil              => resultList.head
        case _ :: tail        =>
          lastNthR(count - 1,
                   if (count > 0) resultList else resultList.tail,
                   tail)
      }
    if (n <= 0) throw new IllegalArgumentException
    else lastNthR(n, ls, ls)
  }
}
