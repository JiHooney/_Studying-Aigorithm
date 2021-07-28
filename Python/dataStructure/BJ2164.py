import sys
from collections import deque

readline = sys.stdin.readline
n = int( readline() )
que = deque()

for i in range( 1, n+1 ):
    que.append( i )

tmp = 0
while len( que ) > 1:
    que.popleft()    
    tmp = que.popleft()
    que.append( tmp )
print( que.pop() )    