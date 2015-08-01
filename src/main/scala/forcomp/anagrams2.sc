import forcomp.Anagrams._

val sentence: Sentence = List("Yes", "man")

val words = (for {
  c <- combinations(sentenceOccurrences(sentence))
} yield dictionaryByOccurrences(c)).distinct.flatten

for {
  i <- 1 to sentence.flatten.length
  w <- words
  if i == w.length
} yield w

val wordLengths = words.groupBy(_.length).keys

def accumulate(accum: Set[Int], i: Int): Set[Int] = {
  println(s"accum=$accum i=$i")
  Set(1)
}

wordLengths.foldLeft(Set[Int]())(accumulate)
