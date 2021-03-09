// using https://scastie.scala-lang.org/ZxB34siaRumSIv55kuIVQA
// https://stackoverflow.com/questions/11215915/scala-type-constraints-doesnt-allow-null

object MyList {
  def last[T >: Null](l: List[T]) : T = {
      l match {
          case x::Nil => x
          case x :: xs => last(xs)
          case Nil => null
      }
  }
}

object Hello {
    def main(args: Array[String]) = {
        println(MyList.last(List(1,2,3)))
    }
}
