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
  else
    for {
      (c, n) <- oc
      x <- 1 to n
      combined <- combines(oc.tail)
      if !combined.exists(y => y._1 == c)
      _ = println("new = " + (c, x))
      _ = println("combined = " + combined)
    } yield (c, x) :: combined
}
combines(oc2)

//val expandedGrouped = expanded groupBy (_._1)

