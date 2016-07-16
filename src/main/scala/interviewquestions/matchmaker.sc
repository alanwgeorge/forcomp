val movieLengths = Map("a" -> 120, "b" -> 100, "c" -> 160, "d" -> 110)

//def matchPair(in: List[Int], f: (Int, Int) => Boolean): List[Tuple2[Int, Int]] =
//  for {
//    x <- in
//    y <- in withFilter (y => f(x, y))
//  } yield (x, y)

//matchPair(movieLengths, (x: Int, y:Int) => x + y == 220)

//movieLengths.flatMap(x => movieLengths.map(y => (x,y)))

movieLengths.get("a") flatMap (a => movieLengths.get("b").map(a + _))

//movieLengths.keys flatMap (x => movieLengths.keys withFilter (y => y != x &&  movieLengths.get(x) + movieLengths.get(y) == 220) map(y => (x,y)))

movieLengths flatMap(x => movieLengths withFilter(y => x._1 != y._1 && x._2 + y._2 == 220) map(y => (x._1,y._1)))