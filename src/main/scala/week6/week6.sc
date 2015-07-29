import scala.language.postfixOps

def isPrime(n: Int): Boolean = {
  if (n == 1) true
  else if (n <= 0) false
  else if ((2 until n) exists (x => ((n.toFloat / x) % 1) == 0)) false
  else true
}

def isPrime2(n: Int): Boolean = {
  (2 until n) forall (x => n % x != 0)
}

def primePairs(max: Int): Seq[(Int, Int)] = (1 until max) flatMap (c => (1 until c) map (d => (c, d))) filter (p => isPrime(p._1 + p._2))
def primePairs3(max: Int): Seq[(Int, Int)] = (1 until max) flatMap (c => (1 until c) map (d => (c, d))) filter {case (x ,y) => isPrime(x + y)}

primePairs(7)
primePairs3(7)

for {
  i <- 1 until 7
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)


def primPairs2(max: Int): Seq[(Int, Int)] = {
  for {
    i <- 1 until max
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j)
}

primPairs2(7)

val n = 7
val m = 2

(1 to m) flatMap (x => 1 to n map (y => (x, y)))

(1 to n) map (y => y)

((1 until n) map (i => (1 until i) map (j => (i, j))) foldRight Seq[(Int, Int)]())(_ ++ _)

//noinspection MapFlatten
((1 until n) map (i => (1 until i) map (j => (i, j)))).flatten

(1 until n) flatMap (i => (1 until i) map (j => (i, j)))

def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map{case (x, y) => x * y}.sum

def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
  (for ((x, y) <- xs zip ys) yield x * y).sum

val o = 1d
val p = 5d
scalarProduct((o to p by 1).toVector, (p to o by -1).toVector)
scalarProduct2((o to p by 1).toVector, (p to o by -1).toVector)