n = int( input() )
arr = list( map(int, input().split() ) )
a = list( set(arr) )
a.sort()
d = { val: idx for idx, val in enumerate(a) }
print( " ".join( str(d[x] ) for x in arr ) )