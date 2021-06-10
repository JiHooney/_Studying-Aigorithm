import sys

n, m, b = map( int, input().split() )

lists = []

for _ in range(n):
    lists.append( list( map(int, input().split() ) ) )


        
#가장 높은 층을 구함
high = max( max(lists) ) 
low = min( min(lists) )
          
time = 9223372036854775807
height = 0

#가장 높은 층에서 0층까지의 땅을 평평하게 했을 때 시간구하기
for k in range(high, low-1, -1):
    x = 0 #x는 인벤토리에 넣을 블록개수
    y = 0 #y는 인벤토리에서 꺼낼 블록 개수
    
    for i in range(n):
        for j in range(m):
            #기준층보다 블록이 많으면 인벤토리에 넣을 블록개수 증가
            if lists[i][j] > k: 
                x += lists[i][j] - k
            #기준층보다 블록이 적으면 인벤토리에서 꺼낼 블록개수 증가
            else:
                y += k - lists[i][j]
    
    #인벤토리에 넣을 블록개수 + 인벤토리 - 필요한 블록개수
    if x+b - y < 0:
        continue
    
    #현재 층의 시간이 전에 층보다 작으면 time과 height를 초기화해준다.
    if (2*x + y) < time:
        time = 2*x + y
        height = k

print( time, height )

