def dfs( x, y ):
    visit[x][y] = 1
    
    for i in range( 4 ):
        nx = x + dx[i]; ny = y + dy[i]
        if nx < 1 or nx > n or ny < 1 or ny > n: continue
        if visit[nx][ny] == 0:
            dfs( nx, ny )
    
    return

import sys
sys.setrecursionlimit( 10**6 )
l = sys.stdin.readline
n = int( l() )
arr = []
arr.append( [ 0 for _ in range( n+1 ) ] )

for i in range( 1, n+1 ):
    arr.append( [0] + list( map(int, l().split()) ) )

Max = max( max( arr ) )
ans = []
dx = [0, 0, -1, 1]; dy = [-1, 1, 0, 0]


for i in range( Max+1 ):
    visit = [ [0]*(n+1) for _ in range( n+1 ) ]
    result = 0

    for j in range( 1, n+1 ):
        for k in range( 1, n+1 ):
            if arr[j][k] <= i: visit[j][k] = 1

    for j in range( 1, n+1 ):
        for k in range( 1, n+1 ):
            if visit[j][k] == 0:
                dfs( j, k )
                result += 1

    ans.append( result )

print( max(ans) )