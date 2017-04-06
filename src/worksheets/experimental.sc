val test = List(1,2,5,3,4)

//Max(1,Max(2,Max(5,Max(3,4))))
//Max(1,Max(2,Max(5,4)))
//Max(1,Max(2,5))
//Max(1,5)
//5

def max(xs: List[Int]) : Int = {
  def maxIter(first: Int, list: List[Int]) : Int = {
    val maxMath = (a: Int, b: Int) => if (a > b) a else b
    if (list.isEmpty) first
    else maxMath(first,maxIter(list.head,list.tail))
  }
  if (xs.isEmpty) throw new NoSuchElementException("empty array")
  else maxIter(xs.head,xs.tail)
}

max(List(1))


//def maxMath = (a: Int, b: Int) => if (a > b) a else b
//maxMath(2,4)