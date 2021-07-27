from collections import deque

n, m = map(int, input().split())

arr = list()

# 2차원 리스?��?�� �? ?���? ?��?��받기
for i in range(0, n):
    arr.append(list(map(int, input())))
    
# ?��?��?�� 4방향 ?��?��(?��?��좌우)
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(x, y):
    sum = 1
    
    # ?��?�� 배열 �? 0?���? 바꿔줘서 방문처리
    arr[x][y] = 0
    
    # ?��?�� ?��?�� �? x,y�? 추�?
    que = deque()
    que.append((x, y))
    
    # ?���? �? ?��까�? 반복?��?��.
    while que:
        # ?��?�� �? ?���?
        now_x, now_y = que.popleft()
        
        # ?��?�� ?��치에?�� ?�� 방향?���? ?���? ?��?��
        for i in range(4):
            x = now_x + dx[i]
            y = now_y + dy[i]
            
            # 배열?�� 벗어?��?�� 값이�? ?��?�� ?��?��
            if x < 0 or x >= n or y < 0 or y >= m:
                continue
                
            # 배열값이1?���?, x?? y�? 기존?�� x, y보다 ?��?? 경우 ?��?��
            if arr[x][y] == 1 and (x > now_x or y > now_y):
                sum += 1
                que.append((x, y))
    
    return sum 

                
# bfs?��?��
sum = bfs(0, 0)
print(sum)
