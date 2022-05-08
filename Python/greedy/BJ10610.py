import sys

n = list(sys.stdin.readline().rstrip())
n.sort( reverse=True )

if n[-1] != '0' or sum(map(int, n)) % 3 != 0:
    print( -1 )
else:
    print( ''.join(n) )