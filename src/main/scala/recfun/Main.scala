package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c < 0) 0
    else if (c > r) 0
    else if (c <= 1 && r <= 1) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def balanceIter(acc: Int, chars: List[Char]): Int = {
      if (chars.isEmpty || acc < 0) acc
      else if (chars.head == '(') balanceIter(acc + 1, chars.tail)
      else if (chars.head == ')') balanceIter(acc - 1, chars.tail)
      else balanceIter(acc, chars.tail)
    }

    balanceIter(0, chars) == 0
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1 // no change or found a solution
    else if (coins.isEmpty) 0 // no more coins
    else if (money < 0) 0 // does not own money or solution doesn't work
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)

  }
}