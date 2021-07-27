from collections import deque

n, m = map(int, input().split())

arr = list()

# 2ì°¨ì› ë¦¬ìŠ¤?Š¸?˜ ë§? ? •ë³? ?…? ¥ë°›ê¸°
for i in range(0, n):
    arr.append(list(map(int, input())))
    
# ?´?™?•  4ë°©í–¥ ? •?˜(?ƒ?•˜ì¢Œìš°)
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(x, y):
    sum = 1
    
    # ?˜„?¬ ë°°ì—´ ê°? 0?œ¼ë¡? ë°”ê¿”ì¤˜ì„œ ë°©ë¬¸ì²˜ë¦¬
    arr[x][y] = 0
    
    # ?°? ?„ ?–¸ ë°? x,yê°? ì¶”ê?
    que = deque()
    que.append((x, y))
    
    # ?ê°? ë¹? ?•Œê¹Œì? ë°˜ë³µ?•œ?‹¤.
    while que:
        # ??˜ ê°? ? œê±?
        now_x, now_y = que.popleft()
        
        # ?˜„?¬ ?œ„ì¹˜ì—?„œ ?„¤ ë°©í–¥?œ¼ë¡? ?œ„ì¹? ?™•?¸
        for i in range(4):
            x = now_x + dx[i]
            y = now_y + dy[i]
            
            # ë°°ì—´?„ ë²—ì–´?‚˜?Š” ê°’ì´ë©? ?‹¤?Œ ?ˆœ?šŒ
            if x < 0 or x >= n or y < 0 or y >= m:
                continue
                
            # ë°°ì—´ê°’ì´1?´ê³?, x?? yê°? ê¸°ì¡´?˜ x, yë³´ë‹¤ ?‘?? ê²½ìš° ?‹¤?–‰
            if arr[x][y] == 1 and (x > now_x or y > now_y):
                sum += 1
                que.append((x, y))
    
    return sum 

                
# bfs?‹¤?–‰
sum = bfs(0, 0)
print(sum)
