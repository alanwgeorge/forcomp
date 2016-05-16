
def f(x: Int) = x * 2
val i = (1 to 5).foldLeft(1) { (acc, n) => {println(s"n=$n"); println(s"acc=$acc");f(acc)} }
def applyNMulti[T](n: Int)(arg: T, f: T => T) = { (1 to n).foldLeft(arg) { (acc, _) => f(acc) } }
def applyNCurried[T](n: Int)(arg: T)(f: T => T) = { (1 to n).foldLeft(arg) { (acc, _) => f(acc) } }
applyNMulti(5)(1, f)
applyNCurried(5)(1)(f)
def nextInt(n :Int) = n * n + 1
def nextNumber[N](n: N)(implicit numericOps: Numeric[N]) = {
  numericOps.plus(numericOps.times(n, n), numericOps.one)
}
nextInt(5)
nextNumber(5.0)
applyNMulti(3)(2, nextInt)
applyNCurried(3)(2)(nextInt)
applyNMulti(3)(2.0, nextNumber[Double])
//applyNCurried(3)(2.0)(nextNumber)

