/**
  * Created by marcelobarbosa on 4/17/17.
  */
package week3

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head : Nothing = throw new NoSuchFieldException("Nil.head")
  def tail : Nothing = throw new NoSuchFieldException("Nil.tail")
}