import funsets.FunSets._

val testSet : Set = n => n > 5
val set10 = singletonSet(10)
val pFilter : (Int => Boolean) = n => n < 5

contains(testSet, -1000)
//contains(testSet, 4)
//contains(testSet, 5)
//contains(testSet, 6)
//contains(testSet, 7)
//
forall(set10, pFilter)

forall(set10, N => N==1000)


val s1 = singletonSet(1)
val s2 = singletonSet(2)
val s3 = singletonSet(3)
val s4 = singletonSet(4)
val s1001 = singletonSet(1001)
val s = union(union(union(s1, s2), union(s3, s1001)),s4) //  {1,2,3,1001,4}
printSet(s)












//def largerSet(b: Int, e: Int) : Set = {
//  require(b<e)
//  val xs = for (i <- b to e) yield i
//  def iter
//}

val exL = List(1,2,3,4,5,6)

exL.forall(pFilter)

