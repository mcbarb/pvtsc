def isSafe(pCol: Int, pQueens: List[Int]): Boolean =
  !((for {
    (i, j) <- pQueens.indices zip pQueens
    sign <- List(-1,0,1)
  } yield sign*(i+1)+j) contains pCol)

def queens(n: Int): Set[List[Int]] = {
  def placeQueens(k: Int): Set[List[Int]] =
    if (k == 0) Set(List())
    else
      for {
        queens <- placeQueens(k-1)
        col <- 0 until n
        if isSafe(col, queens)
      } yield col :: queens
  placeQueens(n)
}

def show(queens: List[Int]) = {
  val lines =
    for (col <- queens.reverse)
      yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
  "\n" + (lines mkString "\n")
}

(queens(8) take 3 map show) mkString "\n"