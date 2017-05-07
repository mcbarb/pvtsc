import forcomp.Anagrams._

val w = "Maarcelo"

def wordOccurrences(w: Word): Occurrences =
  (w.toLowerCase.toList groupBy identity mapValues(_.size) toList).sorted

wordOccurrences(w)

val s = List(w,"oi","zebra")

wordOccurrences(""::List("abcd","e") reduce(_ ++ _))

wordOccurrences("")

lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] =
  dictionary groupBy wordOccurrences withDefaultValue(List())

dictionaryByOccurrences apply wordOccurrences("Marcelo")

List(('a', 1), ('d', 1), ('l', 1), ('r', 1)).toMap.toList.sorted

sentenceAnagrams("I love you".split(" ").toList)
