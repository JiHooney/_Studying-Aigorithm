from collections import deque


# ##bfs ?•¨?ˆ˜ ? •?˜
def bfs(start, arr, visit):
    visit[start] = 1  # ?˜„?¬?…¸?“œ ë°©ë¬¸ì²˜ë¦¬
    
    que = deque()  # ? ?„ ?–¸
    que.append(start)  # ?˜„?¬?…¸?“œë¥? ??— ?„£?Š”?‹¤.
    
    while que:
        now_node = que.pop()  # ??— ?“¤?–´ê°??ˆ?Š” ?…¸?“œë¥? ëº??‹¤.
        
        for i in range(1, n + 1):
            if visit[i] == 0 and arr[now_node][i] == 1:
                que.append(i)  # i?…¸?“œë¥? ??— ?„£?Š”?‹¤.
                visit[i] = 1  # i ?…¸?“œë¥? ë°©ë¬¸ì²˜ë¦¬?•œ?‹¤.
        
    return visit


# ##?—¬ê¸°ì„œë¶??„° ?…? ¥ë°›ìŒ
n, m = map(int, input().split())  # n ?…¸?“œê°œìˆ˜, m ê°„ì„ ê°œìˆ˜
sum = 0  # ?—°ê²°ìš”?†Œ ê°œìˆ˜

# ê°„ì„ ? •ë³? ?–‰? ¬ ?„ ?–¸
arr = [[0] * (n + 1) for i in range(n + 1)]

# ?…¸?“œ ê°„ì„ ? •ë³? ?–‰? ¬ ë§Œë“¤ê¸?
for i in range(0, m):
    a, b = map(int, input().split())  # ?…¸?“œ ê°„ì— ê°„ì„ ? •ë³´ì…? ¥
    
    arr[a][b] = 1
    arr[b][a] = 1
    
# ê°„ì„ ? •ë³´í–‰? ¬ ?˜ ì¶œë ¥?˜?Š”ì§? ?™•?¸?•˜ê¸?
# for i in range(0, n+1):
#     for j in range(0, n+1):
#         print( arr[i][j], end="" )
#     print( end="\n" )

# ?…¸?“œë°©ë¬¸?—¬ë¶? ë¦¬ìŠ¤?Š¸ ë§Œë“¤ê¸?
visit = [ 0 for i in range(n + 1) ]
visit[0] = 1  # 0ë²ˆì§¸ ?¸?±?Š¤?Š” ?•„?š”?—†?œ¼ë¯?ë¡? ë¯¸ë¦¬ 1ë¡? ?„¤? •

start = 1
flag = True

while flag:
    visit = bfs(start, arr, visit)  # bfs?•¨?ˆ˜ ?˜¸ì¶œí•˜ê³? ë°˜í™˜ê°’ìœ¼ë¡? ë°©ë¬¸ë°°ì—´?„ ë°˜í™˜
    sum += 1
    
    for i in range(1, n + 1):
        if visit[i] == 0:
            start = i
            break
        if i == n and visit[i] == 1:
            flag = False

print(sum)
