n = int(input())
a = [0] + list( map( int, input().split() ) )

d = [0] * (n+1)
d[1] = 1

for i in range( 1, n+1 ):
    d[i] = 1
    for j in range( 1, i ):
        if a[i]<a[j] and d[i]<=d[j]:
            d[i] = d[j] + 1
        elif a[i] == a[j]:
            d[i] = d[j]

result = 0
for i in range( 1, n+1 ):
    result = max( d[i], result )

print( result )