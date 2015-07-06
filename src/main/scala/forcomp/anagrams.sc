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

val oc = List(('a', 3), ('b', 3), ('c', 1))

for {
  (c, n) <- oc
  x <- 1 to n
} yield (c,x)

val expanded = oc flatMap (o => (1 to o._2) map (x => (o._1, x)))

val expandedGrouped = expanded groupBy (_._1)

