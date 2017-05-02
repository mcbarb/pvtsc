def concat[T](xs: List[T], ys: List[T]): List[T] =
  (xs foldRight ys)(_ :: _)

def mapFun[T, U](xs: List[T])(f: T => U): List[U] =
  (xs foldRight List[U]())( (l,r) => f(l) :: r )

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)((_,r) => r+1)

concat(List("a","b","c"), List("1","3","2"))

mapFun(List(1,2,3,4))(a => a.toString ++ "_marcelo")

lengthFun(List(1,2,3,4))