from sys import stdin
input = stdin.readline
while True:
    try:
        n = int( input().rstrip() )
    except:
        break
    one = 1
    cnt = 1
    
    while True:
        if one % n == 0: break
        
        cnt += 1
        one = ( one*10+1 ) % n
        
    print( cnt )
