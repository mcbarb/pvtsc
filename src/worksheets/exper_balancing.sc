import java.util.regex.Pattern

/*
parenthesis balancing

"a(b)"
bal('a',bal(List('(','b',')'))
...
bal('a',bal('(',balFinal('b',')')))
bal('a',balFinal('(',')'))
balFinal('a','a')
True

____
Combination of...
( ) _
... taken by 2:

case ('(', '(') => false
case ('(', ')') => true
case ('(',  _ ) => false
case (')', '(') => false
case (')', ')') => false
case (')',  _ ) => false
case ( _ , '(') => false
case ( _ , ')') => false
case ( _ ,  _ ) => true

 */

val test = "a)(a((string))".toList

def balance(chars: List[Char]) : Boolean = {
  def balanceIter(acc: Int, chars: List[Char]): Int = {
    if (chars.isEmpty || acc < 0) acc
    else if (chars.head == '(') balanceIter(acc + 1, chars.tail)
    else if (chars.head == ')') balanceIter(acc - 1, chars.tail)
    else balanceIter(acc, chars.tail)
  }
  balanceIter(0, chars) == 0
}

balance(test.toList)









