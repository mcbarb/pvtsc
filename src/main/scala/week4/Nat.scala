package week4

/**
  * Created by marcelobarbosa on 4/20/17.
  */
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
  def counter (acc: Int) : Int
  override def toString: String = counter(0).toString
}

object Zero extends Nat {
  def isZero: Boolean = true
  def predecessor: Nat = throw new NoSuchElementException("Zero does not have a predecessor")
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = throw new NoSuchElementException("Cannot go negative when subtracting from zero")
  def counter(acc: Int) : Int = acc
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  def predecessor: Nat = n
  def + (that: Nat): Nat = predecessor + that.successor
  def - (that: Nat): Nat = if (that.isZero) this else predecessor - that.predecessor
  def counter(acc: Int) : Int = predecessor.counter(acc + 1)
}

object Main extends App {
  val z = Zero
  val v1 = new Succ(z)
  val v2 = new Succ(new Succ(z))
  val v3 = new Succ(new Succ(new Succ(z)))
  val v4 = new Succ(new Succ(new Succ(new Succ(z))))

  println ("z = " + z.toString)
  println ("v1 = "+v1.toString)
  println ("v2 = "+v2.toString)
  println ("v3 = "+v3.toString)
  println ("v4 = "+v4.toString)

  println ("v1 = "+z.successor.toString)
  println ("v2 = "+z.successor.successor.toString)
  println ("v6 = "+v4.successor.successor.toString)

  println ("v4_ = "+(z + v4).toString)
  println ("v4_ = "+(v2 + v2).toString)
  println ("v6_ = "+(v3 + v3).toString)
  println ("v5_ = "+(v2 + v3).toString)

  println ("v1_ = "+(v3 - v2).toString)

  println ("v4__ = "+(v3 + v3 + v1 - v2 - v1 - z).toString)



//  println (v4 == v2 + v2)

}
