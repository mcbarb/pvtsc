import patmat.Huffman.{Leaf, combine}

val a: List[Char] = "hello world".toList

val b: List[(Char, Int)] = a.groupBy(identity).mapValues(_.size).toList

val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))

combine(leaflist)
