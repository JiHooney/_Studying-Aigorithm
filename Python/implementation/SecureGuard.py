#북쪽 젤 왼쪽점을 기준으로 시계반대방향의 거리를 구함
def dist_calc( x, y ):
    if x == 1: #북
        return y
    elif x == 2: #남
        return a+b+a-y
    elif x == 3: #서
        return a+b+a+b-y
    else:
        return a+y

a, b = map( int, input().split() )

circum = (a+b) * 2

n = int( input() )

dist = []

for i in range(n+1):
    x, y = map( int, input().split() )
    dist.append( dist_calc( x, y ) )
    
my_dist = dist[-1] #동근이 위치
ans = 0

for i in range(n):
    clockwise = abs( my_dist-dist[i] ) #동근이 위치 - 각 상점위치
    ans += min( clockwise, circum-clockwise ) #시계방향거리와 반시계방향 거리를 비교
print( ans )