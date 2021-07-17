t = int(input())
for i in range(0, t):
    n, m = map(int, input().split())
    d = [ [0] for _ in range(m+1) ]
    
    for j in range( 1, m+1 ):
        d[j] = [ 0 for _ in range( j+1 ) ]
        for k in range( 0, j+1 ):
            if k==0 or k==j:
                d[j][k] = 1
            else:
                d[j][k] = d[j-1][k-1] + d[j-1][k]
                
    print( d[m][n] )