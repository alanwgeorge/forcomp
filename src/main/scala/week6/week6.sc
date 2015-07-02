package week6

  object foo {
    def isPrime(n: Int): Boolean = {
      if (n == 1) true
      else if (n <= 0) false
      else if ((2 until n) exists (x => ((n.toFloat / x) % 1) == 0)) false
      else true
    }



    def primePairs(max: Int): Seq[(Int, Int)] = (1 until max) flatMap (c => (1 until c) map (d => (c, d))) filter (p => isPrime(p._1 + p._2))

    primePairs(7)

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

  }
