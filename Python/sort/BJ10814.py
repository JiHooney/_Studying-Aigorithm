n = int(input())
arr = [ [] for _ in range( 201 ) ]

for i in range( n ):
    a, b = input().split()
    arr[int(a)].append( b )
    
for i in range( len(arr) ):
    if arr[i] != []:
        for j in range( len(arr[i]) ): print( i, arr[i][j] )