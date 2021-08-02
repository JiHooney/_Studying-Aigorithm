import sys
l = sys.stdin.readline
n, m = map( int, l().split() )

arr = list( map(int, l().split()) )
start = 0
end = max( arr )

while start <= end:
    mid = (start+end)//2
    sum = 0
    
    for a in arr:
        if a > mid: sum += a - mid
        
    if sum >= m: start = mid + 1
    else: end = mid - 1
print( end )