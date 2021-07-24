t = int(input())

for _ in range( t ):
    k = int(input())
    n = int(input())
    d = [ [0]*n for _ in range( k+1 ) ]
    
    for i in range( k+1 ):
        for j in range( n ):
            if i==0: d[i][j] = j+1
            elif j==0: d[i][j] = 1
            else: d[i][j] = d[i][j-1] + d[i-1][j]
            
    print( d[k][n-1] )