n = int( input() )
p = list( map(int, input().split()) )
p.sort()
s = p[0]
tmp = p[0]
for i in range( 1, n ):
    tmp += p[i]
    s += tmp
print( s )