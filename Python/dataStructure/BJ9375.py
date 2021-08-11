t = int( input() )
for _ in range( t ):
    n = int( input() )
    
    dic = {}
    for _ in range( n ):
        name, type = input().split()
        
        if type in dic.keys(): dic[type] += 1
        else: dic[type] = 1
    
    sum = 1
    for i in dic.values():
        sum *= i+1
    print( sum - 1 )