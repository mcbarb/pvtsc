

def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a+1,acc+f(a))
  }
  loop(a, 0)
}

sum(x => x*x)(4,6)

def product(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 1
  else f(a) * product(f)(a+1,b)
}

product(x => x*x)(3,4)

def factorial(n: Int) = {
  product(x => x)(1,n)
}

factorial(4)
1*2*3*4

def mapReduce(f: Int => Int, combine: (Int , Int) => Int, zero: Int)(a: Int, b: Int): Int = {
  if (a>b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
}

def sum2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x,y) => x+y ,0)(a,b)
sum2(x=>x)(3,5)

def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x,y) => x*y ,1)(a,b)
product2(x=>x)(3,5)