n, k = map( int, input().split() )
d = [0] * (n+1)

for i in range(1,n+1):
    d[i] = [0] * (i+1)
    for j in range(1, i+1):
        if j==1 or j==i:
            d[i][j] = 1
        else: d[i][j] = d[i-1][j-1]+d[i-1][j]
        
print( d[n][k] )