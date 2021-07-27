import sys

n, m, b = map(int, input().split())

lists = []

for _ in range(n):
    lists.append(list(map(int, input().split())))
        
# ê°??ž¥ ?†’?? ì¸µì„ êµ¬í•¨
high = max(max(lists)) 
low = min(min(lists))
          
time = 9223372036854775807
height = 0

# ê°??ž¥ ?†’?? ì¸µì—?„œ 0ì¸µê¹Œì§??˜ ?•…?„ ?‰?‰?•˜ê²? ?–ˆ?„ ?•Œ ?‹œê°„êµ¬?•˜ê¸?
for k in range(high, low - 1, -1):
    x = 0  # x?Š” ?¸ë²¤í† ë¦¬ì— ?„£?„ ë¸”ë¡ê°œìˆ˜
    y = 0  # y?Š” ?¸ë²¤í† ë¦¬ì—?„œ êº¼ë‚¼ ë¸”ë¡ ê°œìˆ˜
    
    for i in range(n):
        for j in range(m):
            # ê¸°ì?ì¸µë³´?‹¤ ë¸”ë¡?´ ë§Žìœ¼ë©? ?¸ë²¤í† ë¦¬ì— ?„£?„ ë¸”ë¡ê°œìˆ˜ ì¦ê?
            if lists[i][j] > k: 
                x += lists[i][j] - k
            # ê¸°ì?ì¸µë³´?‹¤ ë¸”ë¡?´ ? ?œ¼ë©? ?¸ë²¤í† ë¦¬ì—?„œ êº¼ë‚¼ ë¸”ë¡ê°œìˆ˜ ì¦ê?
            else:
                y += k - lists[i][j]
    
    # ?¸ë²¤í† ë¦¬ì— ?„£?„ ë¸”ë¡ê°œìˆ˜ + ?¸ë²¤í† ë¦? - ?•„?š”?•œ ë¸”ë¡ê°œìˆ˜
    if x + b - y < 0:
        continue
    
    # ?˜„?ž¬ ì¸µì˜ ?‹œê°„ì´ ? „?— ì¸µë³´?‹¤ ?ž‘?œ¼ë©? timeê³? heightë¥? ì´ˆê¸°?™”?•´ì¤??‹¤.
    if (2 * x + y) < time:
        time = 2 * x + y
        height = k

print(time, height)

