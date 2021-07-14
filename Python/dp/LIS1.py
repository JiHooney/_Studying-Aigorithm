n = int(input())
a = [0] + list( map( int, input().split() ) )

d = [0] * (n+1)
d[1] = a[1]

for i in range( 2, n+1 ):
    d[i] = a[i]
    for j in range( 1, i ):
        if a[i] > a[j]:
            d[i] = max( d[i], d[j]+a[i] )
            
print( max( d ) )