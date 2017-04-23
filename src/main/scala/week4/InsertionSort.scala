/**
  * Created by marcelo on 4/23/17.
  */

object test extends App {
  def insert(x: Int, xs: List[Int]) : List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

  def isort(xs: List[Int]) : List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  println( isort(List(1,3,4,2,6,7,2,10,3,2)).toString )
}