from sys import stdin
input = stdin.readline

def dfs( row, col, length, hap, arr, drow, dcol ):
    global ans
    global n
    global m
    if length == 4:
        ans = max( [ ans, hap ] )
        return
    
    for i in range( 4 ):
        nrow = row + drow[i]
        ncol = col + dcol[i]
        
        if nrow<0 or ncol<0 or nrow>=n or ncol>=m: continue
        if visit[nrow][ncol] == 1: continue
        
        visit[nrow][ncol] = 1
        dfs( nrow, ncol, length+1, hap+arr[row][col], arr, drow, dcol )
        visit[nrow][ncol] = 0

def additionalPlus( row, col, arr, n, m ):
    global ans
    #ㅗ
    hap = 0
    if row-1>=0 and col-1>=0 and col+1<m:
        hap = arr[row][col-1] + arr[row][col] + arr[row][col+1] + arr[row-1][col]
        ans = max( [hap, ans] )
    
    #ㅜ
    hap = 0
    if row+1<n and col-1>=0 and col+1<m:
        hap = arr[row][col-1] + arr[row][col] + arr[row][col+1] + arr[row+1][col]
        ans = max( [hap, ans] )
    
    #ㅏ
    hap = 0
    if row-1>=0 and row+1<n and col+1<m:
        hap = arr[row-1][col] + arr[row][col] + arr[row+1][col] + arr[row][col+1]
        ans = max( [hap, ans] )
    
    #ㅓ
    hap = 0
    if row-1>=0 and row+1<n and col-1<m:
        hap = arr[row-1][col] + arr[row][col] + arr[row+1][col] + arr[row][col-1]
        ans = max( [hap, ans] )
        
if __name__ == "__main__":
    n, m = map(int, input().split())
    drow = [ 1, -1, 0, 0 ]
    dcol = [ 0, 0, 1, -1 ]
    ans = 0
    arr = []
    visit = [ [0]*m for _ in range( n ) ]
    for i in range( n ):
        arr.append( list( map(int, input().split()) ) )
    
    for i in range( n ):
        for j in range( m ):
            visit[i][j] = 1
            dfs( i, j, 0, 0, arr, drow, dcol )
            visit[i][j] = 0
            
            additionalPlus( i, j, arr, n, m )
            
    print( ans )