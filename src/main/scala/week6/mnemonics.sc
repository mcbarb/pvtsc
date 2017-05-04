val words = (forcomp.loadDictionary filter (word => word forall (chr => chr.isLetter))) ++ List("fun")

val mnem : Map[Char,String] = Map(
  '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
  '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

val charCode: Map[Char,Char] =
  for ((digit, ltrs) <- mnem; ltr <- ltrs) yield ltr -> digit

def wordCode(word: String): String =
  word.toUpperCase map charCode

wordCode("Java")

val wordsForNum: Map[String,Seq[String]] =
  words groupBy wordCode withDefaultValue Seq()

wordsForNum("5282")

def encode(number: String) : Set[List[String]] =
  if (number.isEmpty) Set(List())
  else {
    for {
      split <- 1 to number.length
      word <- wordsForNum(number take split)
      rest <- encode(number drop split)
    } yield word :: rest
  }.toSet

def translate(number: String) : Set[String] =
  encode(number) map (_ mkString " ")

translate("7225247386") // found Scala is fun!
