from collections import deque

###bfs 함수 정의
def bfs( start, arr, visit ):
    visit[start] = 1  #현재노드 방문처리
    
    que = deque()  #큐 선언
    que.append( start )  #현재노드를 큐에 넣는다.
    
    while que:
        now_node = que.pop()  #큐에 들어가있는 노드를 뺀다.
        
        for i in range(1, n+1):
            if visit[i] == 0 and arr[now_node][i] == 1:
                que.append( i )  # i노드를 큐에 넣는다.
                visit[i] = 1  # i 노드를 방문처리한다.
        
    return visit


###여기서부터 입력받음
n,m = map(int, input().split() ) #n 노드개수, m 간선개수
sum = 0  #연결요소 개수

# 간선정보 행렬 선언
arr = [[0] * (n+1) for i in range(n+1)]

# 노드 간선정보 행렬 만들기
for i in range(0, m):
    a, b = map(int, input().split() )  #노드 간에 간선정보입력
    
    arr[a][b] = 1
    arr[b][a] = 1

    
#간선정보행렬 잘 출력되는지 확인하기
# for i in range(0, n+1):
#     for j in range(0, n+1):
#         print( arr[i][j], end="" )
#     print( end="\n" )

#노드방문여부 리스트 만들기
visit = [ 0 for i in range(n+1) ]
visit[0] = 1  #0번째 인덱스는 필요없으므로 미리 1로 설정

start = 1
flag = True

while flag:
    visit = bfs( start, arr, visit )  #bfs함수 호출하고 반환값으로 방문배열을 반환
    sum += 1
    
    for i in range(1, n+1):
        if visit[i] == 0:
            start = i
            break
        if i == n and visit[i] == 1:
            flag = False

print( sum )