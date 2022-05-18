from _collections import deque
dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]

N, M = map(int, input().split())

sea = []
visit = [ [0]*M for _ in range(N) ]

for i in range( N ):
    sea.append( list( map(int, input().split()) ) )

tmp = 0; answer = 0

def bfs( x, y ):
    que = deque()
    que.append( [x, y, 0] )
    visit[x][y] = 1
    
    while que:
        nx, ny, nval = que.popleft()
        
        for i in range( 8 ):
            new_x = dx[i] + nx
            new_y = dy[i] + ny
            new_val = nval
            
            if new_x<0 or new_y<0 or new_x>=N or new_y>=M:
                continue
            if visit[new_x][new_y] == 1:
                continue
            if sea[new_x][new_y] == 1:
                return new_val+1
            
            visit[new_x][new_y] = 1
            que.append( [new_x, new_y, new_val+1] )
            
    return 0

for i in range( N ):
    for j in range( M ):
        if( sea[i][j] == 1):
            continue
        
        tmp = bfs(i, j)
        answer = tmp if tmp > answer else answer

print( answer )