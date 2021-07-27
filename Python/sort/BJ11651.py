import sys
readline = sys.stdin.readline
n = int( readline() )

arr = [ [0]*2 for _ in range( n ) ]

for i in range( n ):
    a, b = map( int, readline().split() )
    arr[i][0] = a; arr[i][1] = b

arr.sort( key= lambda x : ( x[1], x[0] ) )

for i in range( n ):
    print( arr[i][0], arr[i][1] )