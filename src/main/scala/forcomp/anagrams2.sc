import forcomp.Anagrams._

//val sentence: Sentence = List("Linux", "rulez")
//val sentence: Sentence = List("Yes", "man")
val sentence: Sentence = List("I", "love", "you")
val words = (for {
  c <- combinations(sentenceOccurrences(sentence))
} yield dictionaryByOccurrences(c)).distinct.flatten

for {
  i <- 1 to sentence.flatten.length
  w <- words
  if i == w.length
} yield w
val wordLengths = words.groupBy(_.length).keys.toSet
sentence.flatten.length

def occuranceValidation(source: Occurrences, target: Occurrences): Boolean = {
  val check = for {
    t <- target
    s <- source
    if t._1 == s._1
  } yield t._2 <= s._2

  !check.contains(false)
}
def addElement[T](master: Set[Set[T]], element: T): Set[Set[T]] = {
  //  println(s"master=$master element=$element")
  master ++ master.map(_ + element)
}
def addElementList(master: Set[List[Int]], element: Int): Set[List[Int]] = {
  println(s"master=$master element=$element")
  master ++ master.map(m => element :: m)
}

def setProduct[T](ints: Set[T]): Set[Set[T]] = {
  ints.foldLeft(Set(Set[T]()))(addElement)
}

def setProductList(ints: Set[Int]): Set[List[Int]] = {
  ints.foldLeft(Set(List[Int]()))(addElementList)
}

def addWord2(master: Set[List[Word]], element: Word): Set[List[Word]] = {
  //    println(s"master=$master element=$element")
  master ++
    master.map(m => if (occuranceValidation(sentenceOccurrences(sentence), sentenceOccurrences(element :: m))) element :: m else m)
//  ++
//    master.map(m => if (occuranceValidation(sentenceOccurrences(sentence), sentenceOccurrences(element :: m))) m ++ List(element) else m)
}
def addWord(master: Set[List[Word]], element: Word): Set[List[Word]] = {
//  println(s"master=$master element=$element")
  val v = master.map(m => if (occuranceValidation(sentenceOccurrences(sentence), sentenceOccurrences(element :: m))) element :: m else m)

  val combos = for {
    s <- v
    c <- s.permutations
  } yield c

//  if (master == Set(List())) v
//  else master ++ v
  master ++ v ++ combos
}
def wordProduct(words: Set[Word]): Set[List[Word]] = {
  words.foldLeft(Set(List[Word]()))(addWord)
}
def findParts(parts: Set[Int], whole: Int): Set[List[Int]] = {
  setProductList(parts).filter(_.sum == whole)
}
//findParts(wordLengths, sentence.flatten.length)
//findParts(Set(1,2,3,4,5), 10)
//setProductList(wordLengths)
//setProduct(words.toSet)
wordProduct(Set("alan", "george", "foo", "bar")).filter(_.length == 4)
wordProduct(words.toSet)
//wordProductL(words.toSet).size
