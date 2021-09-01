from sys import stdin
input = stdin.readline
n, m, k = map(int, input().split())
arr = [ list( map(int, input().split()) ) for _ in range( n ) ]
visit = [ [False]*m for _ in range( n ) ]
numMax = -10001
drow = [ 0, 0, 1, -1 ]
dcol = [ 1, -1, 0, 0 ]

def search( row, col, depth, hap ):
    if depth == k:
        global numMax
        if numMax < hap: numMax = hap
        return
    
    for i in range( row, n ):
        for j in range( col if i == row else 0, m ):
            #현재 위치 방문 여부 확인
            if visit[row][col]: continue
            
            ok = True
            #상하좌우 방문여부 확인
            for i in range( 4 ):
                nrow = i + drow[i]
                ncol = j + dcol[i]
                
                if 0<=nrow<n and 0<=ncol<m:
                    if visit[nrow][ncol]: ok = False
                    
            #방문하기
            if ok:
                visit[i][j] = True
                search( i, j, depth+1, hap+arr[i][j] )
                visit[i][j] = False

search( 0, 0, 0, 0 )
print( numMax )