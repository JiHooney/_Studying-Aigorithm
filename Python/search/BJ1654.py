def chk( arr, n, mid ):
    cnt = 0
    for i in range( len(arr) ):
        cnt += arr[i] // mid
    return cnt >= n

import sys
l = sys.stdin.readline
k, n = map( int, l().split() )
arr = [ int( l() ) for _ in range( k ) ]

ans = 0; start = 0; end = max( arr )
while start <= end:
    mid = (start+end) // 2
    mid = mid if mid != 0 else 1
    if chk( arr, n, mid ):
        ans = max( ans, mid )
        start = mid + 1
    else: end = mid - 1
print( ans )