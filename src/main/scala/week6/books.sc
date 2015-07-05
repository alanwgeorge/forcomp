case class Book(title: String, autors: List[String])

val books: Set[Book] = Set(
  Book(title = "Structure and Interpretation of Computer Programs", autors = List("Abelson, Harold", "Sussman, Gerald J.")),
  Book(title = "Introduction to Functional Programming", autors = List("Bird, Richard", "Wadler, Phil")),
  Book(title = "Effective Java", autors = List("Bloch, Joshua")),
  Book(title = "Effective Java 2", autors = List("Bloch, Joshua")),
  Book(title = "Java Puzzlers", autors = List("Bloch, Joshua", "Gafter, Neal")),
  Book(title = "Programming in Scala", autors = List("Odersky, Martin", "Spoon, Lex", "Venner, Bill"))
)

for {
  b <- books
  a <- b.autors
  if a.startsWith("Bloch,")
} yield b.title

for {
  b <- books
  a <- b.autors withFilter (a => a startsWith "Bloch,")
} yield b.title

books flatMap (b => for (a <- b.autors withFilter (a => a startsWith "Bloch,")) yield b.title)

books flatMap (b => b.autors withFilter (a => a startsWith "Bloch,") map (a => b.title))

for {
  b <- books
  if b.title.indexOf("Program") >= 0
} yield b.title

for {
  b <- books withFilter (b => (b.title indexOf "Program") >= 0)
} yield b.title

books withFilter (b => (b.title indexOf "Program") >= 0) map (b => b.title)

for {
  b1 <- books
  b2 <- books
  if b1.title < b2.title
  a1 <- b1.autors
  a2 <- b2.autors
  if a1 == a2
} yield a1

val n = 10
val a = (0 to n) withFilter (x => x % 2 == 0) map ((_, n))

val b = for {
x <- 0 to n withFilter(x => x % 2 == 0)
} yield (x, n)

assert(a == b)

case class Person(name: String, isMale: Boolean, children: Person*)

val lara = Person("Lara", isMale = false)
val bob = Person("Bob", isMale = true)
val julie = Person("Julie", isMale = false, lara, bob)
val persons = List(lara, bob, julie)

persons withFilter (p => !p.isMale) flatMap (p => p.children map (c => (p.name, c.name)))

for {
  p <- persons
  if !p.isMale
  c <- p.children
} yield (p.name, c.name)