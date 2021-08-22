from sys import stdin
input = stdin.readline
n = int( input() )
arr = [ [0]*n for _ in range( n ) ]
for i in range( n ):
    s = input().rstrip()
    for j in range( n ):
        arr[i][j] = s[j]

def check( arr, n, ans ):
    for i in range( n ):
        cnt = 1
        for j in range( n-1 ):
            if arr[i][j] == arr[i][j+1]: cnt += 1
            else: cnt = 1
            ans = cnt if cnt > ans else ans
            
    for i in range( n ):
        cnt = 1
        for j in range( n-1 ):
            if arr[j][i] == arr[j+1][i]: cnt += 1
            else: cnt = 1
            ans = cnt if cnt > ans else ans
            
    return ans

ans = 0
#각 행에 대해서 자리바꾼 뒤 최대값 찾기
for i in range( n ):
    for j in range( n-1 ):
        tmp = arr[i][j]
        arr[i][j] = arr[i][j+1]
        arr[i][j+1] = tmp
        
        ans = check( arr, n, ans )
        
        tmp = arr[i][j]
        arr[i][j] = arr[i][j+1]
        arr[i][j+1] = tmp
        
#각 열에 대해서 자리바꾼 뒤 최대값 찾기
for i in range( n ):
    for j in range( n-1 ):
        tmp = arr[j][i]
        arr[j][i] = arr[j+1][i]
        arr[j+1][i] = tmp
        
        ans = check( arr, n, ans )
        
        tmp = arr[j][i]
        arr[j][i] = arr[j+1][i]
        arr[j+1][i] = tmp
print( ans )