import sys

def sosu( i, m, n, arr ):
    if arr[i] == 1: return False
    for j in range( i+i, n+1, i ): arr[j] = 1
    if i >= m and i <= n: return True

m, n = map(int, sys.stdin.readline().split() )
arr = [0] * (n+1)
print( "".join( str(i)+"\n" if sosu( i, m, n, arr ) else "" for i in range( 2, n+1 ) ) )