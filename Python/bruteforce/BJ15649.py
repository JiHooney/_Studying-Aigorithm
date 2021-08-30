from sys import stdin
from itertools import permutations
input = stdin.readline

n, m = map(int, input().split())
a = list( map( str, range( 1, n+1 ) ) )
print( '\n'.join( map( ' '.join, permutations(a, m) ) ) )