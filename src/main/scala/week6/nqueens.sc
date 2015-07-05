

def isSafe(col: Int, queens: List[Int]): Boolean = {
  if (queens.isEmpty) true
  else if (queens.contains(col)) false
  else if (queens.head == col - 1 || queens.head == col + 1) false
  else true
}

def isSafe2(col: Int, queens: List[Int]): Boolean = {
  val row: Int = queens.length
  val partialSolutionTuple: Seq[(Int, Int)] = (row - 1 to 0 by -1) zip queens
  partialSolutionTuple forall {
    case (r, c) => col != c && math.abs(col - c) != row - r
  }
}

def queens(rows: Int): Set[List[Int]] = {
  def placeQueen(k: Int): Set[List[Int]] = {
    if (k == 0) Set(List())
    else
      for {
        queens <- placeQueen(k - 1)
        col <- 0 until rows
        if isSafe2(col, queens)
      } yield col :: queens
  }
  placeQueen(rows)
}

queens(5).count(p => true)
def printSolution(solution: List[Int]): String = {
  val lines = for {
    place <- solution.reverse
  } yield Vector.fill(solution.length)("#").updated(place, place).mkString
  "\n" + lines.mkString("\n")
}

queens(5) map printSolution

(3 to 0 by -1) zip List(1,3,0,2)

