def dfs( x, y ):
    if x==m and y==n :
        return 1
    
    if dp[x][y] == -1:  #방문안함
        dp[x][y] = 0
        
        for i in range( 4 ):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx<=0 or nx>m or ny<=0 or ny>n:
                continue
            
            if arr[x][y] > arr[nx][ny]:
                dp[x][y] += dfs( nx, ny )
    
    return dp[x][y]  #방문했다면 예전에 방문했던 값 반환

m, n = map( int, input().split() )

arr = [ [0] * (n+1) for _ in range( m+1) ]
for i in range( 1, m+1 ):
    arr[i] = [0] + list( map( int, input().split() ) )

dp = [ [-1] * (n+1) for _ in range( m+1) ]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

print( dfs(1, 1) )