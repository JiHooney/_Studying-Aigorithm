import sys
l = sys.stdin.readline
n, k = map(int, l().split())
dp = [ [0]*(k+1) for _ in range( n+1 ) ]

for i in range( 1, n+1 ):
    for j in range( 1, k+1 ):
        if i==1: dp[i][j] = j; continue
        if j==1: dp[i][j] = 1
        else: dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000
print( dp[n][k] % 1000000000 )