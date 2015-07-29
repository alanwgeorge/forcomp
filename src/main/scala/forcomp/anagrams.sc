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

val t = oc1 flatMap (o1 => oc2 map (o2 => if (o1._1 == o2._1) (o1._1, o1._2 - o2._2) else o1))

def smallest(o: Occurrences): Int = {
  o match {
    case (c, n) :: Nil => n
    case (c1, n1) :: (c2, n2) :: rest => if (n1 <= n2) smallest((c1, n1) :: rest) else smallest((c2, n2) :: rest)
    case _ => 0
  }
}

def smallest2(o: Occurrences): Int = (o.head /: o )((x, y) => if (x._2 <= y._2) x else y)._2

smallest2(oc1)
oc1.minBy(_._2)._2

val u  = t.groupBy(_._1)

val w = u map(i => (i._1, smallest2(i._2)))

val x = ('a', u('a'))

def map2List(in: Map[Char, Int]): List[(Char, Int)] = {
  if (in == Map()) Nil
  else (in.keys.head, in(in.keys.head)) :: map2List(in - in.keys.head)
}

map2List(w)

val l = List(1, 2, 3, 4, 5)
val zero = 1
def op(x: Int, y: Int) = x * y

l.reduce(op)
l.reduceLeft(op)
l.reduceRight(op)
l.fold(zero)(op)
l.foldLeft(zero)(op)
l.foldRight(zero)(op)
l.sum

//subtract(oc1, oc2)