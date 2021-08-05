import sys
n, m = map( int, input().split() )

nList = sys.stdin.read().splitlines()
a = set( nList[:n] )
b = set( nList[n:] )
res = list( a & b )
res.sort()
print( str( len(res) )+"\n"+"\n".join( i for i in res ) )