n, m = map(int, input().split())
arr = []
a = 999

for _ in range( n ):
    arr.append( input() )

for i in range( n-7 ):
    for j in range( m-7 ):
        c = arr[i][j]
        s = 0
        for k in range( i, i+8 ):
            for z in range( j, j+8 ):
                if arr[k][z]!=c: s += 1

                if z==j+7: continue
                elif c=='W': c = 'B'
                elif c=='B': c = 'W'

        s = min( s, 64-s )
        a = min( s, a )
        
print( a )