from collections import deque


# BFS 메서?�� ?��?��
def bfs(graph, start, visited):
    # ?�� 구현?�� ?��?�� deque ?��?��브러�? ?��?��
    queue = deque([start])

    # ?��?�� ?��?���? 방문처리
    visited[start] = True

    # ?���? �? ?��까�? 반복
    while queue:
        # ?��?��?�� ?��?��?�� ?��?���? 뽑아 출력
        v = queue.popleft()
        print(v, end=' ')

        # ?��?�� ?��?��?? ?��결된, ?���? 방문?���? ?��?? ?��?��?��?�� ?��?�� ?��?��
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


# �? ?��?���? ?��결된 ?��보�?? 리스?�� ?��료형?���? ?��?��(2차원 리스?��)
graph = [
         [],
         [2, 3, 8],
         [1, 7],
         [1, 4, 5],
         [3, 5],
         [3, 4],
         [7],
         [2, 6, 8],
         [1, 7]
]

# �? ?��?���? 방문?�� ?��보�?? 리스?�� ?��료형?���? ?��?��(1차원 리스?��)
visited = [False] * 9

# ?��?��?�� BFS?��?�� ?���?
bfs(graph, 1, visited)
