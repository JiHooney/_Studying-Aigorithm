import sys

n, m, b = map(int, input().split())

lists = []

for _ in range(n):
    lists.append(list(map(int, input().split())))
        
# �??�� ?��?? 층을 구함
high = max(max(lists)) 
low = min(min(lists))
          
time = 9223372036854775807
height = 0

# �??�� ?��?? 층에?�� 0층까�??�� ?��?�� ?��?��?���? ?��?�� ?�� ?��간구?���?
for k in range(high, low - 1, -1):
    x = 0  # x?�� ?��벤토리에 ?��?�� 블록개수
    y = 0  # y?�� ?��벤토리에?�� 꺼낼 블록 개수
    
    for i in range(n):
        for j in range(m):
            # 기�?층보?�� 블록?�� 많으�? ?��벤토리에 ?��?�� 블록개수 증�?
            if lists[i][j] > k: 
                x += lists[i][j] - k
            # 기�?층보?�� 블록?�� ?��?���? ?��벤토리에?�� 꺼낼 블록개수 증�?
            else:
                y += k - lists[i][j]
    
    # ?��벤토리에 ?��?�� 블록개수 + ?��벤토�? - ?��?��?�� 블록개수
    if x + b - y < 0:
        continue
    
    # ?��?�� 층의 ?��간이 ?��?�� 층보?�� ?��?���? time�? height�? 초기?��?���??��.
    if (2 * x + y) < time:
        time = 2 * x + y
        height = k

print(time, height)

