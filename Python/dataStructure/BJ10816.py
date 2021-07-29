import sys
line = sys.stdin.readline

n = int( line() )
nrr = [ 0 for _ in range( 20000001 ) ]

tmp = list( map( int, line().split() ) )
for i in tmp: nrr[10000000+i] += 1

s = ""
m = int( line() )
tmp2 = list( map(int, line().split()) )
for i in range( m ):
    if nrr[ 10000000+tmp2[i] ] != 0: s += str( nrr[ 10000000+tmp2[i] ] ) + " "
    else: s += "0 "
    
print( s )