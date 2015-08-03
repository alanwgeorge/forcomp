import forcomp.Anagrams._

//val sentence: Sentence = List("Linux", "rulez")
//val sentence: Sentence = List("Yes", "man")
//val sentence: Sentence = List("I", "love", "you")
val sentence: Sentence = List("Heather")
val words = (for {
  c <- combinations(sentenceOccurrences(sentence))
} yield dictionaryByOccurrences(c)).flatten.sorted
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
def setProduct[T](ints: Set[T]): Set[Set[T]] = {
  ints.foldLeft(Set(Set[T]()))(addElement)
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
//findParts(wordLengths, sentence.flatten.length)
//findParts(Set(1,2,3,4,5), 10)
//setProductList(wordLengths)
//setProduct(words.toSet)
wordProduct(Set("alan", "george", "foo", "bar")).filter(_.length == 4)
wordProduct(words.toSet)
//wordProductL(words.toSet).size

Set(List("re", "the", "ha"), List("he", "hat", "re"), List("three", "ha"), List("hare", "the"), List("her", "Thea"), List("at", "he", "her"), List("her", "et", "ha"), List("re", "ah", "the"), List("hear", "the"), List("et", "her", "ha"), List("he", "re", "hat"), List("hat", "re", "he"), List("heather"), List("he", "heart"), List("re", "ha", "the"), List("here", "hat"), List("he", "at", "her"), List("he", "hater"), List("ah", "three"), List("her", "heat"), List("he", "earth"), List("there", "ha"), List("ha", "re", "the"), List("re", "heath"), List("et", "ha", "her"), List("ah", "et", "her"), List("ah", "her", "et"), List("re", "the", "ah"), List("ha", "ether"), List("ha", "her", "et"), List("at", "her", "he"), List("ha", "there"), List("ether", "ha"), List("ah", "re", "the"), List("hate", "her"), List("the", "hear"), List("earth", "he"), List("Rhea", "the"), List("three", "ah"), List("et", "ah", "her"), List("her", "et", "ah"), List("the", "hare"), List("the", "re", "ah"), List("re", "hat", "he"), List("her", "at", "he"), List("hat", "he", "re"), List("ha", "the", "re"), List("the", "Hera"), List("ah", "the", "re"), List("et", "her", "ah"), List("ha", "three"), List("heat", "her"), List("hater", "he"), List("the", "ha", "re"), List("he", "her", "at"), List("heart", "he"), List("there", "ah"), List("ah", "there"), List("ah", "ether"), List("Hera", "the"), List("her", "he", "at"), List("hat", "here"), List("ha", "et", "her"), List("the", "ah", "re"), List("her", "ah", "et"), List("ether", "ah"), List("the", "Rhea"), List("her", "hate"), List("re", "he", "hat"), List("heath", "re"), List("Thea", "her"), List("her", "ha", "et"), List("the", "re", "ha"))
Set(List("re", "the", "ha"), List("he", "hat", "re"), List("three", "ha"), List("hare", "the"), List("her", "Thea"), List("at", "he", "her"), List("her", "et", "ha"), List("re", "ah", "the"), List("hear", "the"), List("he", "he", "art") , List("et", "her", "ha"), List("he", "re", "hat"), List("hat", "re", "he"), List("heather"), List("he", "heart"), List("re", "ha", "the"), List("here", "hat"), List("he", "at", "her"), List("he", "hater"), List("ah", "three"), List("her", "heat"), List("he", "earth"), List("there", "ha"), List("ha", "re", "the"), List("re", "heath"), List("et", "ha", "her"), List("ah", "et", "her"), List("ah", "her", "et"), List("re", "the", "ah"), List("he", "he", "rat"), List("rat", "he", "he"), List("ha", "ether"), List("ha", "her", "et"), List("he", "tar", "he"), List("he", "rat", "he"), List("at", "her", "he"), List("ha", "there"), List("ether", "ha"), List("art", "he", "he"), List("ah", "re", "the"), List("tar", "he", "he"), List("hate", "her"), List("the", "hear"), List("he", "art", "he"), List("earth", "he"), List("Rhea", "the"), List("three", "ah"), List("et", "ah", "her"), List("her", "et", "ah"), List("the", "hare"), List("the", "re", "ah"), List("re", "hat", "he"), List("her", "at", "he"), List("hat", "he", "re"), List("he", "he", "tar"), List("ha", "the", "re"), List("the", "Hera"), List("ah", "the", "re"), List("et", "her", "ah"), List("ha", "three"), List("heat", "her"), List("hater", "he"), List("the", "ha", "re"), List("he", "her", "at"), List("heart", "he"), List("there", "ah"), List("ah", "there"), List("ah", "ether"), List("Hera", "the"), List("her", "he", "at"), List("hat", "here"), List("ha", "et", "her"), List("the", "ah", "re"), List("her", "ah", "et"), List("ether", "ah"), List("the", "Rhea"), List("her", "hate"), List("re", "he", "hat"), List("heath", "re"), List("Thea", "her"), List("her", "ha", "et"), List("the", "re", "ha"))
wordOccurrences("Heather")
sentenceAnagrams(List("Heather"))