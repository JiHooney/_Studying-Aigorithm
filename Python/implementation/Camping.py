
case = 1
result = 0
while True:
    l, p, v = map( int, input().split() )
    
    if l==0:  break
    
    mok = int(v/p)
    rem = v%p
    
    result = mok*l + min(l, rem)
    
    print( "Case "+ str(case) +": "+ str(result) )
    case += 1
