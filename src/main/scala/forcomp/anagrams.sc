import forcomp.Anagrams._

val a = "alan"
def pack[T](packList: List[T]): List[List[T]] = {
  packList match {
    case Nil => Nil
    case x :: xs => val (first, rest) = packList span (y => y == x); first :: pack(rest)
  }
}
pack(a.sorted.toList) map (l => (l.head, l.length))
val s: Sentence = List("abcde", "e")
pack(s.flatten) map (l => (l.head, l.length))
wordAnagrams("alangeorge")
val oc1 = List(('a', 4), ('b', 3), ('c', 1))
val oc2 = List(('a', 2), ('b', 2))
val oc3 = List(('a', 2), ('b', 1), ('c', 1))
for {
  (c, n) <- oc1
  x <- 1 to n
} yield (c,x)
val expanded = oc1 map (o => (1 to o._2) map (x => (o._1, x)))
def combines(oc: Occurrences): List[Occurrences] = {
  if (oc.isEmpty) List(List())
  else {
    for {
      combined <- combines(oc.tail)
      x <- 0 to oc.head._2
    } yield if (x == 0) Nil else List((oc.head._1, x)) ++ combined
  }.distinct
}
combines(oc2)

def makeOccur(c: Char, n: Int): List[(Char, Int)] = if (n == 0) Nil else List((c, n))

def combines2(oc: Occurrences): List[Occurrences] = {
  if (oc.isEmpty) List(List())
  else
    combines2(oc.tail) flatMap
      (combined => 0 to oc.head._2 map
        (x => makeOccur(oc.head._1, x) ++ combined))
}
combines2(oc2)
//val expandedGrouped = expanded groupBy (_._1)
(for {
  m <- (for ((c1, n1) <- oc1; (c2, n2) <- oc2) yield if (c1 == c2) (c1, n1 - n2) else (c1, n1)).distinct.groupBy(_._1)
} yield (m._1, m._2.minBy(_._2)._2)).toList.filter(_._2 > 0).sorted


subtract(oc1, oc1)

def subtract2(x: Occurrences, y: Occurrences): Occurrences = {
  def subtractTerm(innerMap: Map[Char, Int], term: (Char, Int)): Map[Char, Int] = {
    val (c, i) = term
    if (innerMap(c) - i > 0)
      innerMap + (c -> (innerMap(c) - i))
    else innerMap - c
  }

  def subtr(xm: Map[Char, Int], ym: Map[Char, Int]) = {
    ym.foldLeft(xm)(subtractTerm)
  }

  subtr(x.toMap,y.toMap).toList.sorted
}

//val s2: Sentence = List("Linux", "rulez")
val s2: Sentence = List("Yes", "man")
s2.flatten.length

//val combos = combinations(sentenceOccurrences(s2))

val words = (for {
  c <- combinations(sentenceOccurrences(s2))
} yield dictionaryByOccurrences(c)).distinct.flatten

def buildSentence(part: Sentence, length: Int, source: List[String]): Sentence = {
  source match {
    case List() =>
//      println("Nil")
      List()
    case word :: rest =>
//      println(s"0word=$word")
      if ((part.flatten.length + word.length) == length) {
//        println(s"1word=$word")
        word :: part
      } else if ((part.flatten.length + word.length) < length) {
//        println(s"1word=$word length=$length")
        buildSentence(word :: part, length, rest)
      } else {
//        println(s"2word=$word")
        buildSentence(part, length, rest)
      }
  }
}

buildSentence(List(), s2.flatten.length, words)

(for {
  word <- words
} yield {
//    println(s"word=$word")
    buildSentence(List(word), s2.flatten.length, words)
}).filter(s => s.length > s2.flatten.length)

sentenceAnagrams(List("Yes", "man"))