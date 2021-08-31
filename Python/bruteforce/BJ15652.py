from sys import stdin
from itertools import combinations_with_replacement

input = stdin.readline
n, m = map(int, input().split())
print( '\n'.join( map(' '.join, combinations_with_replacement( map(str, range(1, n+1)), m ) ) ) )