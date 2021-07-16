n = int(input())
d = [0] * 81
d[1] = 4
d[2] = 6
for i in range( 3, n+1 ):
    d[i] = d[i-2] + d[i-1]
    
print( d[n] )