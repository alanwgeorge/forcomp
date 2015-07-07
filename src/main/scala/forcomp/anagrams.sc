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

val oc1 = List(('a', 3), ('b', 3), ('c', 1))
val oc2 = List(('a', 2), ('b', 2))
val oc3 = List(('a', 2), ('b', 1), ('c', 2))

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

