from sys import stdin
input = stdin.readline
n = int( input() )
arr = [ [0]*2 for _ in range( n ) ]
for i in range( n ):
    arr[i][0], arr[i][1] = map(int, input().split())
ans = 0

def dfs( idx, pay ):
    global n, ans, arr
    if idx >= n:
        ans = max( [ans, pay] )
        return
    
    if idx+arr[idx][0] <= n: dfs( idx+arr[idx][0], pay+arr[idx][1] )
    else: dfs( idx+arr[idx][0], pay )
    
    dfs( idx+1, pay )

dfs( 0, 0 )
print( ans )