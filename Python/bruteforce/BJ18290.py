from sys import stdin

def search( row, col, depth, hap ):
    global n, m, k, numMax
    if depth == k:
        if numMax < hap: numMax = hap
        return
    
    for i in range( row, n ):
        for j in range( m ):
            #현재 위치 방문 여부 확인
            if visit[i][j]: continue
            
            ok = True
            #상하좌우 방문여부 확인
            for z in range( 4 ):
                nrow = i + drow[z]
                ncol = j + dcol[z]
                
                if not (0<=nrow<n and 0<=ncol<m): continue
                if visit[nrow][ncol]: 
                    ok = False
                    
            #방문하기
            if ok:
                visit[i][j] = True
                search( i, j, depth+1, hap+arr[i][j] )
                visit[i][j] = False

input = stdin.readline
n, m, k = map(int, input().split())
arr = [ list( map(int, input().split()) ) for _ in range( n ) ]
visit = [ [False]*m for _ in range( n ) ]
numMax = -10001
drow = [ 0, 0, 1, -1 ]
dcol = [ 1, -1, 0, 0 ]

search( 0, 0, 0, 0 )
print( numMax )