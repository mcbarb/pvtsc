def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)

isPrime(10)

isPrime(5)


val n = 7

(1 until n).flatMap(i =>
  (1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))

for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i+j)
} yield (i,j)

def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
  val l = for {
    (x,y) <- xs zip ys
  } yield x*y
  l.sum
}

scalarProduct(List(1,2,3,4,5), List(2,2,2,2,2))