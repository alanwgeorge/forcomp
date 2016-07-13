
lazy val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map {n => n._1 + n._2}


(0 to 4) map {fibs(_)}


