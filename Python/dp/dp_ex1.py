from collections import deque


# bfs method
def bfs(i, j):
    que = deque()
    que.append([i, j])
    visit[i][j] = True;
    result[danji] += 1
    
    while que:
        now = que.pop()
        now_x = now[0]
        now_y = now[1]
        
        for k in range(4):
            nx = now_x + dx[k]
            ny = now_y + dy[k]
            
            if(nx >= 0 and ny >= 0 and nx < n and ny < n):
                if(arr[nx][ny] == 1 and visit[nx][ny] == False):
                    que.append([nx, ny])
                    visit[nx][ny] = True
                    result[danji] += 1


n = int(input())

arr = []
visit = []
result = [0 for i in range(n)]
danji = 0
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for i in range(n):
    arr.append(list(map(int, input())))
    visit.append([False for k in range(n)])
    
for i in range(n):
    for j in range(n):
        if(arr[i][j] == 1 and visit[i][j] == False):
            danji += 1
            bfs(i, j)

result.sort()
print(danji)
for i in range(len(result)):
    if result[i] != 0:
        print(result[i])
