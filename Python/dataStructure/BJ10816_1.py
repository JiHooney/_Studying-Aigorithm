import sys
from collections import Counter
line = sys.stdin.readline
n = line()
nrr = line().split()
m = line()
mrr = line().split()

c = Counter( nrr )
print( ' '.join( str(c[i]) if i in c else '0' for i in mrr ) )