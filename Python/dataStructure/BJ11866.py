import sys
from collections import deque
l = sys.stdin.readline
n, k = map(int, l().split())

q = deque()
for i in range( 1, n+1 ): q.append( i )

s = "<"

while len(q) > 1:
    for _ in range( k-1 ): q.append( q.popleft() )
    s += str( q.popleft() )+", "
    
s += str( q.popleft() )+">"
print( s )