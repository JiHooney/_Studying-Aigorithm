t = int(input())
arr = [300, 60, 10]
ans = [0] * 3

for i in range( 3 ):
    ans[i] = t//arr[i]
    t -= arr[i]*ans[i]
    
if t!=0:
    print( -1 )
else:
    print( *ans )