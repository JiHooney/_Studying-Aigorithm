import sys
l = sys.stdin.readline
n, m = map(int, l().split())
book1 = []
book2 = {}
ans = []

for i in range( 1, n+1 ):
    name = l().rstrip()
    book1.append( name )
    book2[ name ] = i
    
for _ in range( m ):
    po = l().rstrip()
    if po.isdigit(): ans.append( book1[ int(po)-1 ] )
    else: ans.append( str( book2[po] ) )
print( "\n".join( ans ) )