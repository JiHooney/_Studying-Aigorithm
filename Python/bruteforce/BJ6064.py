from sys import stdin
input = stdin.readline
for _ in range( int(input()) ):
    X, Y, x, y = map( int, input().split() )
    f = 1
    a = 0
    if Y == y: a=1
    while( x <= X*Y ):
        if a == 0:
            if( x%Y == y ):
                print( x )
                f = 0
                break
        else: 
            if( x%Y == y or x%Y == 0 ):
                print( x )
                f = 0
                break
        x += X
    if f: print( -1 )