

def isSafe(col: Int, queens: List[Int]): Boolean = {
  if (queens.isEmpty) true
  else if (queens.contains(col)) false
  else if (queens.head == col - 1 || queens.head == col + 1) false
  else true
}

def queens(rows: Int): Set[List[Int]] = {
  def placeQueen(k: Int): Set[List[Int]] = {
    if (k == 0) Set(List())
    else
      for {
        queens <- placeQueen(k - 1)
        col <- 0 until rows
        if isSafe(col, queens)
      } yield col :: queens
  }
  placeQueen(rows)
}

queens(10).count(l => true)



