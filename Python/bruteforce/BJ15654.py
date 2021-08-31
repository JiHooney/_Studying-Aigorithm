from sys import stdin

def dfs( depth ):
    global n, m, arr, ans
    if depth == m:
        print( ' '.join( map(str, ans) ) )
        return
    
    for i in range( 0, n ):
        if visit[i]:
            continue
        else:
            ans[depth] = arr[i]
            visit[i] = True
            dfs( depth+1 )
            visit[i] = False
        

input = stdin.readline
n, m = map( int, input().split() )
ans = [0] * m
visit = [False] * n 

arr = list( map(int, input().split()) )
arr.sort()

dfs( 0 )