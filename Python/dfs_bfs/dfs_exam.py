def dfs(graph, v, visited):
    # ?˜„?¬ ?…¸?“œë¥? ë°©ë¬¸ì²˜ë¦¬
    visited[v] = True
    print(v, end=' ')

    # ?˜„?¬ ?…¸?“œ?? ?—°ê²°ëœ ?‹¤ë¥? ?…¸?“œë¥? ?¬ê·?? ?œ¼ë¡? ë°©ë¬¸
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


# ê°? ?…¸?“œê°? ?—°ê²°ëœ ? •ë³´ë?? ë¦¬ìŠ¤?Š¸ ?ë£Œí˜•?œ¼ë¡? ?‘œ?˜„(2ì°¨ì› ë¦¬ìŠ¤?Š¸)
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

# ê°? ?…¸?“œê°? ë°©ë¬¸?œ ? •ë³´ë?? ë¦¬ìŠ¤?Š¸ ?ë£Œí˜•?œ¼ë¡? ?‘œ?˜„(1ì°¨ì› ë¦¬ìŠ¤?Š¸)
visited = [False] * 9
# print( visited ) => [False, False, False, False, False, False, False, False, False]

# ? •?˜?œ DFS ?•¨?ˆ˜ ?˜¸ì¶?
dfs(graph, 1, visited)
