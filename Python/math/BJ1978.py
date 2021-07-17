n = int(input())
sum = 0

num = [0] + list( map( int, input().split() ) )

for j in range( 1, n+1 ):
    for k in range( 2, num[j]+1 ):
        if k!=num[j] and num[j]%k==0:
            break
        elif k==num[j] and num[j]%k==0:
            sum += 1
            
print( sum )