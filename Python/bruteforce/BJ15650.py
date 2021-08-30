from sys import stdin

def dfs( index, depth ):
    global n, m, arr, s
    if depth == m:
        for val in arr: s += str(val)+" "
        s += "\n"
        return
    
    for i in range( index, n+1 ):
        arr[depth] = i
        dfs( i+1, depth+1 )

input = stdin.readline
n, m = map(int, input().split())
arr = [0]*m
s = ""
dfs( 1, 0 )
print( s )