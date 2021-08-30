from sys import stdin

def dfs( index, depth ):
    global n, m, arr
    if depth == m: 
        print( ' '.join( map(str, arr) ) )
        return
    
    for i in range( 1, n+1 ):
        arr[depth] = i
        dfs( i, depth+1 )

input = stdin.readline
n, m = map(int, input().split())
arr = [0] * m
dfs( 1, 0 )