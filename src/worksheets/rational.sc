class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x,1)

  private def gcd(a: Int, b: Int): Int = if (b==0) a else gcd(b,a % b)
  val numer = x // gcd(x,y)
  val denom = y // gcd(x,y)

  def + (that: Rational) = new Rational(
    numer * that.denom + that.numer * denom,
    denom * that.denom
  )

  def unary_- = new Rational(-numer,denom)

  def - (that: Rational) = this + -that

  def * (that: Rational) = new Rational(numer * that.numer, denom * that.denom)

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that:Rational) = if (this < that) that else this

  override def toString = {
    val g = gcd(numer, denom)
    numer / g + "/" + denom / g
  }


}

val x = new Rational(1,2)
val y = new Rational(1,3)
val z = new Rational(5,7)
//new Rational(1,0)


x - y
x + x
z + z
z * z


x + x - z
