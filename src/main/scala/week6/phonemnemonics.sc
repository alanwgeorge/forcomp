import scala.io.Source

val in: Source = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")

val words: List[String] = in.getLines().toList

val mnem: Map[Char, String] = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

val charCode: Map[Char, Char] = (for ((n, s) <- mnem; c <- s) yield c -> n) withDefaultValue ' '
val charCode2: Map[Char, Char] = mnem flatMap (n => for (c <- n._2) yield c -> n._1) withDefaultValue ' '
val charCode3: Map[Char, Char] = mnem flatMap (n => n._2 map (c => c -> n._1)) withDefaultValue ' '

def wordCode(word: String): String = for (c <- word.toUpperCase) yield charCode3(c)
def wordCode2(word: String): String = word.toUpperCase map charCode3

wordCode("alan")
wordCode("alan george")
wordCode2("alan george")
wordCode2("java")
wordCode2("cybernetics")
wordCode2("wellsfargo")

val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode2 withDefaultValue Seq()

wordsForNum("2526")
wordsForNum("29237638427")

def encode(number: String): Set[List[String]] = {
  if (number.isEmpty) Set(List())
  else {
    for {
      split <- 1 to number.length
      word <- wordsForNum(number take split)
      rest <- encode(number drop split)
    } yield word :: rest
  }.toSet
}

encode("7225247386")
encode("4156253130")
encode("93557")