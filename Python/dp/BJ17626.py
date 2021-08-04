n = int( __import__('sys').stdin.readline() )
dp = [0] * (n+1)
dp[1] = 1
for i in range( 2, n+1 ):
    m = 9999
    for j in range( 1, i+1 ):
        if j*j > i: break
        tmp = i - j*j
        m = min( m, dp[tmp] )
    dp[i] = m + 1
print( dp[n] )