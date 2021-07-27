def dfs(graph, v, visited):
    # ?��?�� ?��?���? 방문처리
    visited[v] = True
    print(v, end=' ')

    # ?��?�� ?��?��?? ?��결된 ?���? ?��?���? ?���??��?���? 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


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
# print( visited ) => [False, False, False, False, False, False, False, False, False]

# ?��?��?�� DFS ?��?�� ?���?
dfs(graph, 1, visited)
