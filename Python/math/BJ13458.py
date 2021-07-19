n = int(input())
a = list( map(int, input().split()) )
b, c = map(int, input().split())
sum = 0

for i in range( n ):
    a[i] -= b
    sum += 1
    if a[i]<=0:
        continue
    if a[i]%c != 0:
        sum += ( a[i]//c ) + 1
    else:
        sum += ( a[i]//c )
        
print( sum )