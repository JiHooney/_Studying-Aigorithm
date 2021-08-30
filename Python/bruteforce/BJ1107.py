from sys import stdin
import math

input = stdin.readline
n = int(input())
m = int(input())

remocon = [False]*10
if m!=0: 
    tmp_list = list( map(int, input().split()) )
    for i in tmp_list: remocon[i] = True

ans = abs( n - 100 )

for i in range( 1000000 ):
    channel = i
    chk = False
    buttonCnt = len( str(i) )

    for j in range( buttonCnt, 0, -1 ):
        v_pow = math.pow( 10, j-1 )
        if remocon[ int( channel//v_pow ) ]:
            chk = True
            break
        
        channel -= (int(channel//v_pow))*v_pow
    
    if( chk ): continue
    else: 
        ans = min( [ ans, buttonCnt+abs( n-i ) ] )
print( ans )