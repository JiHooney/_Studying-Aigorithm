n = int( input() )
t = [0] * (n+1)
p = [0] * (n+1)
d = [0] * (n+1)

for i in range( 1, n+1 ):
    t[i], p[i] = map( int, input().split() )

m = 0
for i in range( 1, n+1 ):
    m = max( m, d[i-1] )
    if i-1+t[i] <= n:
        d[i-1+t[i]] = max( m+p[i], d[i-1+t[i]] )
        
print( max(d) )