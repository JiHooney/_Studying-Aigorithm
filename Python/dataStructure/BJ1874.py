import sys
from collections import deque
l = sys.stdin.readline
n = int( l() )

res = "" 
s = deque()

s.append( 1 )
s.append( 2 )

start = 0
for _ in range( n ):
    val = int( l() )
    if start < val:
        for i in range( start+1, val+1 ):
            s.append( i )
            res += "+\n"
        start = val
    elif s[ len(s)-1 ] != val:
        print( "NO" )
        sys.exit()
    s.pop()
    res += "-\n"
print( res )