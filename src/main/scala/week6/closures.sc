
def makeIncreaser(more: Int): Int => Int = x => x + more

val inc10 = makeIncreaser(10)
val inc9999 = makeIncreaser(9999)

inc10(10)
inc9999(10)




