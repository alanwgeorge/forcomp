package interviewquestions

object HighestProduct extends App {
  val ints1 = List(-10,-10,1,3,2, -10)

  def highestProduct(in: List[Int]): Int = {
    val perms = for {
      i1 <- in
      i2 <- in
      i3 <- in
    } yield i1 * i2 * i3

    perms.sortWith(_ > _).head
  }

  def highestProduct2(in: List[Int]): Int = {
    def accum(remander: List[Int], currentWinners: List[Int], max: Int): Int = {
      remander match {
        case List() => max
        case i :: r => currentWinners match {
          case x :: y :: z => i
        }
      }
    }

    val sorted = in.sortWith(_.abs > _.abs)

    accum(sorted.drop(3), sorted.take(3), sorted.take(3).product)
  }

  println(highestProduct(ints1))
}
