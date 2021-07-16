k = int(input())

d = [ [0]*2 for i in range( k+1 ) ]

if k <= 1:
    d[1][0] = 0
    d[1][1] = 1
    print( d[1][0], d[1][1] )
else:
    d[1][0] = 0
    d[1][1] = 1
    d[2][0] = 1
    d[2][1] = 1
    for i in range( 3, k+1 ):
        d[i][0] = d[i-1][0]+d[i-2][0]
        d[i][1] = d[i-1][1]+d[i-2][1]

    print( d[k][0], d[k][1] )