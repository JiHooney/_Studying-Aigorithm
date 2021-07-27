from collections import deque


# BFS ë©”ì„œ?“œ ? •?˜
def bfs(graph, start, visited):
    # ? êµ¬í˜„?„ ?œ„?•´ deque ?¼?´ë¸ŒëŸ¬ë¦? ?‚¬?š©
    queue = deque([start])

    # ?˜„?¬ ?…¸?“œë¥? ë°©ë¬¸ì²˜ë¦¬
    visited[start] = True

    # ?ê°? ë¹? ?•Œê¹Œì? ë°˜ë³µ
    while queue:
        # ??—?„œ ?•˜?‚˜?˜ ?›?†Œë¥? ë½‘ì•„ ì¶œë ¥
        v = queue.popleft()
        print(v, end=' ')

        # ?•´?‹¹ ?›?†Œ?? ?—°ê²°ëœ, ?•„ì§? ë°©ë¬¸?•˜ì§? ?•Š?? ?›?†Œ?“¤?„ ??— ?‚½?…
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


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

# ? •?˜?œ BFS?•¨?ˆ˜ ?˜¸ì¶?
bfs(graph, 1, visited)
