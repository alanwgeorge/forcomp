package interviewquestions

object StockProfit extends App {
  val prices1: Seq[Int] = Seq(11,12,13,10,10,9)
  val prices2: Seq[Int] = Seq(10,7,5,8,11,9)
  val prices3: Seq[Int] = Seq(10,11,12,13,14,15)
  val prices4: Seq[Int] = Seq(10,9,8,7,6,5,4,3,2,1)
  val prices5: Seq[Int] = Seq(1,2,3,4,5,6,7,8,9,10)

  def maxProfit(prices: Seq[Int]): Int = {
    def accum(remainder: Seq[Int], currentMax: Int): Int = {
      remainder match {
        case c :: Nil => currentMax
        case c :: r if (r.max - c) > currentMax => accum(r, r.max - c)
        case c :: r => accum(r, currentMax)
      }
    }

    accum(prices, prices.min - prices.max)
  }

  println(maxProfit(prices1))
  println(maxProfit(prices2))
  println(maxProfit(prices3))
  println(maxProfit(prices4))
  println(maxProfit(prices5))
}
