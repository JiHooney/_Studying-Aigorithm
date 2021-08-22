from sys import stdin
input = stdin.readline
arr = []; hap = 0
for i in range( 9 ):
    arr.append( int( input() ) )
    hap += arr[i]

arr.sort()
bre = False
for i in range( len(arr) ):
    for j in range( i+1, len(arr) ):
        if hap - ( arr[i] + arr[j] ) == 100:
            for k in range( len(arr) ): 
                if k == i or k == j: continue
                else: print( arr[k] )
            bre = True
            break
    if bre: break