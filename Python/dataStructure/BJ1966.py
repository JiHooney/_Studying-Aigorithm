import sys
from collections import deque
l = sys.stdin.readline
t = int( l() )

for _ in range( t ):
    que = deque()
    n, m = map( int, l().split() )

    tmp = list( map(int, l().split()) )
    for i in range( n ):
        que.append( [ i, tmp[i] ] )
    
    for i in range( n-1 ):
        j = i+1
        while j < n:
            if que[i][1] < que[j][1]:
                tmp = que[i]
                que.remove( tmp )
                que.append( tmp )
                j = i+1
            else: j += 1
            
    for i in range( n ):
        if m == que[i][0]: print( i+1 )