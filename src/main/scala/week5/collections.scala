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

  val a1: List[Int] = List(1,2,3,4,5,6)
  println(last(a1))
  println(init(a1))
  println(concat(a1,reverse(a1)))
  println(removeAt(1, List('a', 'b', 'c', 'd')))
  println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
}