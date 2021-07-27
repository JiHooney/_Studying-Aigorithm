# 북쪽 ?�� ?��쪽점?�� 기�??���? ?��계반??방향?�� 거리�? 구함
def dist_calc(x, y):
    if x == 1:  # �?
        return y
    elif x == 2:  # ?��
        return a + b + a - y
    elif x == 3:  # ?��
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
    
my_dist = dist[-1]  # ?��근이 ?���?
ans = 0

for i in range(n):
    clockwise = abs(my_dist - dist[i])  # ?��근이 ?���? - �? ?��?��?���?
    ans += min(clockwise, circum - clockwise)  # ?��계방?��거리?? 반시계방?�� 거리�? 비교
print(ans)
