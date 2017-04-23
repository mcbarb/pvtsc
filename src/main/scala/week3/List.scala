/**
  * Created by marcelobarbosa on 4/17/17.
  */
package week3

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true
  def head : Nothing = throw new NoSuchFieldException("Nil.head")
  def tail : Nothing = throw new NoSuchFieldException("Nil.tail")
}

//object List {
//  // List(1,2)
//  def apply[T](a: T, b: T) : List[T] = new Cons(a,new Cons(b,new Nil))
//  def apply() = new Nil
//}

object test {
  val x: List[String] = Nil

//  def f(xs: List[NonEmpty], x: Empty) = xs prepend x

}