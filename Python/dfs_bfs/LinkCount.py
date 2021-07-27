from collections import deque


# ##bfs ?��?�� ?��?��
def bfs(start, arr, visit):
    visit[start] = 1  # ?��?��?��?�� 방문처리
    
    que = deque()  # ?�� ?��?��
    que.append(start)  # ?��?��?��?���? ?��?�� ?��?��?��.
    
    while que:
        now_node = que.pop()  # ?��?�� ?��?���??��?�� ?��?���? �??��.
        
        for i in range(1, n + 1):
            if visit[i] == 0 and arr[now_node][i] == 1:
                que.append(i)  # i?��?���? ?��?�� ?��?��?��.
                visit[i] = 1  # i ?��?���? 방문처리?��?��.
        
    return visit


# ##?��기서�??�� ?��?��받음
n, m = map(int, input().split())  # n ?��?��개수, m 간선개수
sum = 0  # ?��결요?�� 개수

# 간선?���? ?��?�� ?��?��
arr = [[0] * (n + 1) for i in range(n + 1)]

# ?��?�� 간선?���? ?��?�� 만들�?
for i in range(0, m):
    a, b = map(int, input().split())  # ?��?�� 간에 간선?��보입?��
    
    arr[a][b] = 1
    arr[b][a] = 1
    
# 간선?��보행?�� ?�� 출력?��?���? ?��?��?���?
# for i in range(0, n+1):
#     for j in range(0, n+1):
#         print( arr[i][j], end="" )
#     print( end="\n" )

# ?��?��방문?���? 리스?�� 만들�?
visit = [ 0 for i in range(n + 1) ]
visit[0] = 1  # 0번째 ?��?��?��?�� ?��?��?��?���?�? 미리 1�? ?��?��

start = 1
flag = True

while flag:
    visit = bfs(start, arr, visit)  # bfs?��?�� ?��출하�? 반환값으�? 방문배열?�� 반환
    sum += 1
    
    for i in range(1, n + 1):
        if visit[i] == 0:
            start = i
            break
        if i == n and visit[i] == 1:
            flag = False

print(sum)
