t = int( input() )

arr = [0] * 11

for i in range(t):
    n = int( input() )
    
    arr[1] = 1
    arr[2] = 2
    arr[3] = 4
    
    for j in range(4, n+1):
        arr[j] = arr[j-1] + arr[j-2] + arr[j-3]
    
    print( arr[n] )