from sys import stdin

def dfs( depth ):
    global n, m, arr, ans
    if depth == m:
        print( ' '.join( map(str, ans) ) )
        return
    
    for i in range( 0, n ):
        ans[depth] = arr[i]
        dfs( depth+1 )
        

input = stdin.readline
n, m = map(int, input().split())
arr = list( map(int, input().split()) )
ans = [0] * m
arr.sort()
dfs( 0 )