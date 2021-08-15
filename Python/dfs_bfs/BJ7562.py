from collections import deque

dx = [ -1, -1, -2, -2,  1, 1,  2, 2 ]
dy = [ -2,  2, -1,  1, -2, 2, -1, 1 ]

def bfs( a, b, arr ):
    que = deque()
    vis[a][b] = 1
    
    ans = 0
    que.append( [a, b, ans] )
    
    while que:
        for i in range( 8 ):
            print( i )
            tmp = que.popleft()
            print( tmp )
            
            n_x = a + dx[i]
            n_y = b + dy[i]
            
            if arr[n_x][n_y] == 1:
                return tmp[2]
            
            if n_x < 0 or n_y < 0 or n_x >= len(arr) or n_y >= len(arr):
                continue
            
            if vis[n_x][n_y] != 1:
                vis[n_x][n_y] = 1
                que.append( [ n_x, n_y, tmp[2]+1 ] )
        
    
    return 0

t = int( input() )

for _ in range( t ):
    n = int( input() )
    
    arr = list( [0]*n for _ in range( n ) )
    vis = list( [0]*n for _ in range( n ) )
    a, b = map(int, input().split())
    x, y = map(int, input().split())
    arr[x][y] = 1
    print( bfs( a, b, arr ) )