/**
  * Created by marcelo on 4/28/17.
  */

object main extends App {

  def last[T](list: List[T]) : T = list match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case _ :: xs => last(xs)
  }

  def init[T](list: List[T]) : List[T] = list match { // I could work to make it tail recursive
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case x :: xs => x :: init(xs)
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs,ys)
  }

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case y :: ys => reverse(ys) ++ List(y)
  }

  def removeAt0[T](acc: List[T], m: Int, ys: List[T]): List[T] = ys match {
    case List() => ys
    case z :: zs => if (m == 0) acc ++ zs else removeAt0(acc ++ List(z), m-1, zs)
  }

  def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
    case List() => xs
    case y => if (n<0) xs else removeAt0(List(),n,y)
  }

  def flatten(xs: List[Any]): List[Any] = xs match {
    case List() => xs
    case (y : List[Any]) :: ys => flatten(y) ::: flatten(ys)
    case z :: zs => z :: flatten(zs)
  }

  def SplitAt[T](xs: List[T], n: Int): (List[T],List[T]) = (xs take n, xs drop n)

  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length/2
    if (n==0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil, ys1) => ys1
          case (xs1, Nil) => xs1
          case (x :: xs1, y :: ys1) =>
            if (ord.lt(x , y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      val (fst, snd) = SplitAt(xs,n)
      merge(msort(fst),msort(snd))
    }
  }

  val a1: List[Int] = List(1,2,3,4,5,6)
  println(last(a1))
  println(init(a1))
  println(concat(a1,reverse(a1)))
  println(removeAt(1, List('a', 'b', 'c', 'd')))
  println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
  println(SplitAt(List(),10))
  val nums = List(1,4,2,4,7,2,9,0,-1,2)
  val fruits = List("pineapple","apple","banana","orange")
  println(msort(nums))
  println(msort(fruits))


}