class Poly(val terms0: Map[Int, Double]) {
  def this(bindings: (Int,Double)*) = this(bindings.toMap)
  def terms = terms0 withDefaultValue 0.0
  def + (other: Poly) : Poly = new Poly((other.terms foldLeft terms)(addTerm))
  def addTerm(terms: Map[Int,Double], term: (Int,Double)) : Map[Int,Double] = {
    val (exp, coef) = term
    terms + (exp -> (coef + terms(exp)))
  }
  override def toString: String =
    (for ((exp, coef) <- terms.toList.sorted) yield coef+"x^"+exp) mkString " + "
}

val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))
p1 + p2