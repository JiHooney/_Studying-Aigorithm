from sys import stdin
def cal( index, depth ):
    global n, arr, visit, ans
    if depth == (n//2):
        t1 = 0; t2 = 0
        for i in range( n ):
            for j in range( i+1, n ):
                if visit[i] and visit[j]:
                    t1 += arr[i][j]
                    t1 += arr[j][i]
                elif visit[i]==False and visit[j]==False:
                    t2 += arr[i][j]
                    t2 += arr[j][i]
        
        cha = abs( t1-t2 )
        if cha == 0:
            print( cha )
            exit()
        
        ans = min( [ans, cha] )
        return
    
    for i in range( index, n-1 ):
        if not visit[i]:
            visit[i] = True
            cal( i+1, depth+1 )
            visit[i] = False

input = stdin.readline
n = int(input())
arr = []
for _ in range( n ):
    arr.append( list( map(int, input().split()) ) )

visit = [False] * n
ans = 9999
cal( 0, 0 )
print( ans )