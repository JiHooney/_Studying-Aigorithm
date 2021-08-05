import sys
l = sys.stdin.readline
n, m = map(int, l().split() )

d = {}
for i in range( n ):
    site, pas = l().split()
    d[site] = pas
print( "\n".join( d[ i.strip() ] for i in sys.stdin ) )