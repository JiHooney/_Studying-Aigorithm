# ë¶ìª½ ? ¤ ?™¼ìª½ì ?„ ê¸°ì??œ¼ë¡? ?‹œê³„ë°˜??ë°©í–¥?˜ ê±°ë¦¬ë¥? êµ¬í•¨
def dist_calc(x, y):
    if x == 1:  # ë¶?
        return y
    elif x == 2:  # ?‚¨
        return a + b + a - y
    elif x == 3:  # ?„œ
        return a + b + a + b - y
    else:
        return a + y


a, b = map(int, input().split())

circum = (a + b) * 2

n = int(input())

dist = []

for i in range(n + 1):
    x, y = map(int, input().split())
    dist.append(dist_calc(x, y))
    
my_dist = dist[-1]  # ?™ê·¼ì´ ?œ„ì¹?
ans = 0

for i in range(n):
    clockwise = abs(my_dist - dist[i])  # ?™ê·¼ì´ ?œ„ì¹? - ê°? ?ƒ? ?œ„ì¹?
    ans += min(clockwise, circum - clockwise)  # ?‹œê³„ë°©?–¥ê±°ë¦¬?? ë°˜ì‹œê³„ë°©?–¥ ê±°ë¦¬ë¥? ë¹„êµ
print(ans)
