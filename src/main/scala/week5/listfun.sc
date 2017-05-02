/**
  * Created by marcelo on 5/2/17.
  */

def squareList(xs: List[Int]): List[Int] =
  xs match {
    case Nil => xs
    case y :: ys => (y * y) :: squareList(ys)
  }

def squareList2(xs: List[Int]): List[Int] =
  xs map (x => x * x)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: _ =>
    val (first,rest) = xs span (y => y == x)
    first :: pack(rest)
}

def encode2[T](xs: List[T]): List[(T,Int)] = xs match {
  case Nil => Nil
  case x :: _ =>
    val (first,rest) = xs span (y => y == x)
    (x,first.length) :: encode(rest)
}

def encode[T](xs: List[T]): List[(T,Int)] = pack(xs) map (ys => (ys.head,ys.length))

val nums = List(1,4,2,4,7,2,9,0,-1,2)
val fruits = List("pineapple","apple","banana","orange")

squareList(nums)
squareList2(nums)
pack(List("a", "a", "a", "b", "c", "c", "a"))
encode(List("a", "a", "a", "b", "c", "c", "a"))
//List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))

