from sys import stdin

def dfs( start, depth ):
    global n, m, arr, ans, visit
    if depth == m:
        print( ' '.join( map(str, ans) ) )
        return
    
    for i in range( start, n ):
        if depth == 0:
            visit[i] = True
            ans[depth] = arr[i]
            dfs( i+1, depth+1 )
            
        if visit[i]:
            pass
        else: 
            ans[depth] = arr[i]
            dfs( i+1, depth+1 )
            

input = stdin.readline
n, m = map(int, input().split())
arr = list( map(int, input().split()) )
arr.sort()
ans = [0] * m
visit = [False] * n
dfs( 0, 0 )
