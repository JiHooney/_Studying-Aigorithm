import sys
l = sys.stdin.readline
print = sys.stdout.write
t = int( l() )

bitMask = 0
for _ in range( t ):
    Order, *arr = l().split()
    if arr: x = int( arr[0] )
    
    if Order == "add": bitMask = bitMask | (1<<(x-1))
    elif Order == "remove": bitMask = bitMask & ~(1<<(x-1))
    elif Order == "check": print( "1\n" if bitMask & (1<<(x-1)) == 1<<(x-1) else "0\n" )
    elif Order == "toggle": bitMask = bitMask ^ (1<<(x-1))
    elif Order == "all": bitMask = ~0
    else: bitMask = 0   #empty