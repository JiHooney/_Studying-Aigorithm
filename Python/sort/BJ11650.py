import sys
readline = sys.stdin.readline
n = int( readline() )

#x좌표가-100000 ~ 1000000 이므로 -100000일때는 100000-100000=0인덱스
#x가 100000일 때는 100000+100000 = 200000 인덱스가 되도록
#arr배열의 크기를 200000으로 설정한다.
arr = [ [] for _ in range(200001) ]
for _ in range(n):
    a, b = map( int, readline().split() )
    
    #배열의 100000인덱스가 좌표값 0이라고 가정한다.
    #이를 위해서 x좌표값에 100000을 더하고 이를 인덱스로 사용한다.
    #x좌표 인덱스 배열에 b값을 추가시킨다.
    arr[100000 + a].append( b )

#arr크기인 200001까지 순회
for i in range(len(arr)):
    #0이 아닌경우에는 i인덱스 배열에 값이 존재한다는 거니깐
    if len(arr[i]) != 0:    
        arr[i].sort()   #y좌표값을 오름차순으로 정렬
        for j in range(len(arr[i])):
            print(i - 100000, arr[i][j])    #y좌표 개수만큼 출력