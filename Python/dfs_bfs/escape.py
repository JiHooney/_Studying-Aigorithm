from collections import deque

n, m = map(int, input().split() )

arr = list()

#2차원 리스트의 맵 정보 입력받기
for i in range(0, n):
    arr.append( list( map(int, input() ) ) )
    
#이동할 4방향 정의(상하좌우)
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs( x, y ):
    sum = 1
    
    #현재 배열 값 0으로 바꿔줘서 방문처리
    arr[x][y] = 0
    
    #데큐 선언 및 x,y값 추가
    que = deque()
    que.append( (x, y) )
    
    #큐가 빌 때까지 반복한다.
    while que:
        #큐의 값 제거
        now_x, now_y = que.popleft()
        
        #현재 위치에서 네 방향으로 위치 확인
        for i in range( 4 ):
            x = now_x + dx[i]
            y = now_y + dy[i]
            
            #배열을 벗어나는 값이면 다음 순회
            if x < 0 or x >= n or y < 0 or y >= m:
                continue
                
            #배열값이1이고, x와 y가 기존의 x, y보다 작은 경우 실행
            if arr[x][y] == 1 and ( x > now_x or y > now_y ):
                sum += 1
                que.append( (x, y) )
    
    return sum 
                
#bfs실행
sum = bfs( 0, 0 )
print( sum )