n = int( input() )
d = [0] * (n+1)

for i in range( 1, n+1 ):
    tmp = i
    j = int( pow(i, 0.5) )
    while j>=1:
        tmp = min( tmp, d[ i-int(pow(j,2)) ] )
        j -= 1
    d[i] = tmp + 1
    
print( d[n] )