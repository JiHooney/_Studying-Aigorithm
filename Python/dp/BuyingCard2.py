n = int( input() )
p = [0] + list( map( int, input().split() ) )
d = [10001] * (n+1)

d[0] = 0
d[1] = 1

for i in range( 2, n+1 ):
    for j in range( 0, i ):
        d[i] = min( d[i], d[j]+p[i-j] )

print( d[n] )