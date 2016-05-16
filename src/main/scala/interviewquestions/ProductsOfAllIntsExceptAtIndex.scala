package interviewquestions

object ProductsOfAllIntsExceptAtIndex extends App {
  val nums1 = List(1,7,3,4)

  val results = for {
    i <- 0 to nums1.length
  } yield (nums1.take(i) ++ nums1.drop(i + 1)).product

  println(results)
}
