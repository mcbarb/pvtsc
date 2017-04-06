/*
pascal triangle
pascal(c, r) = pascal(c-1,r-1) + pascal(c,r-1)
pascal ~ p
______

   0 1 2 3 4
0: 1
1: 1 1
2: 1 2 1
3: 1 3 3 1
4: 1 4 6 4 1

______
p(0,0) = 1
p(0,1) = 1
p(1,1) = 1

______
finding 1: if c > r then p(c,r) = 0

p(2,2)
p(1,1)+p(2,1)
1 + 0

_____
finding 2: if c < 0 then p(c,r) = 0

p(1,3)
p(0,2) + p(1,2)
p(-1,1) + p(0,1) + p(0,1) + p(1,1)
0 + 1 + 1 + 1
3

*/
def pascal(c: Int, r: Int) : Int = {
  if (c<0) 0
  else if (c>r) 0
  else if (c<=1 && r<=1) 1
  else pascal(c-1,r-1) + pascal(c,r-1)
}

pascal(-1,-1) // 0
pascal(-1,1) // 0
pascal(0,0) // 1
pascal(0,1) // 1
pascal(1,0) // 0
pascal(1,1) // 1

pascal(1,3)
pascal(3,3)
