def init[T](xs: List[T]): List[T] = xs match {
  case Nil => throw new Error("init of empty list")
  case x :: Nil => Nil
  case y :: ys => y :: init(ys)
}

val l1 = List(1,2,3,4,5,6,7,8,9)

init(init(l1))

def reverse[T](xs: List[T]): List[T] = xs match {
  case Nil => Nil
  case y :: ys => reverse(ys) ++ List(y)
}

reverse(l1)

def removeAt[T](n: Int, xs: List[T]): List[T] = {
  val (beg, end) = xs splitAt n
  beg ++ end.tail
}

removeAt(1 , l1)

val l2: List[Any] = List(List(1,1), 2, List(3, List(5,8)))

def flatten(list: List[Any]): List[Any] = list match {
  case Nil => Nil
  case (head: List[Any]) :: tail => flatten(head) ++ flatten(tail)
  case head :: tail => head :: flatten(tail)
}

flatten(l2)


