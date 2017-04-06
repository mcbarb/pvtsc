//def countChange(money: Int, coins: List[Int]): Int = {
//  def endMoney(initialMoney: Int, coins: List[Int]) : Int {
//
//  }
//}

/*

                      change 4, coins(1,2)
                       /           \
                  1                 2
                  4-1=3             4-2=2
                /       \                \
           1              2               2
           3-1=2          3-2=1           2-2=0[/]
          /    \            \
      1         2            2
      2-1=1     2-2=0[/]     1-2=-1[x]
      /    \
 1          2
 1-1=0[/]   1-2=-1[x]

______

change(amount,coins)
rest = amount - coins.head
rest > 0 -> change(rest,coins) + change(rest,coin.tail)
rest = 0 -> found answer -> + 1
rest < 0 -> did not find answer, stop -> 0

 */

def countChange(money: Int, coins: List[Int]): Int = {
  if (money ==0) 1 // no change or found a solution
  else if (coins.isEmpty) 0 // no more coins
  else if (money < 0) 0 // does not own money or solution doesn't work
  else countChange(money,coins.tail) + countChange(money-coins.head,coins)

}

countChange(4,List(1,2))
countChange(300,List(5,10,20,50,100,200,500))










