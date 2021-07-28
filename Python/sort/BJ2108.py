import sys

readline = sys.stdin.readline
n = int( readline() )

Mean = 0
Mid = 0
Mode = 0
Range = 0

arr = [ 0 for _ in range( 8001 ) ]
Max = -5000; Min = 5000;
Sum = 0


for _ in range( n ):
    tmp = int( readline() )
    if tmp < Min: Min = tmp
    if tmp > Max: Max = tmp
    Sum += tmp

    arr[ 4000+tmp ] += 1

brr = []; crr = []
tmp = 1
for i in range( 4000+Min, 4000+Max+1 ):

    if arr[i] >= 1:
        for _ in range( arr[i] ): 
            crr.append( i-4000 )

        if arr[i] > tmp:
            brr = []
            tmp = arr[i]
            brr.append( i-4000 )

        elif arr[i] == tmp:
            brr.append( i-4000 )

Mean = round( Sum/n )

Mid = crr[ len(crr)//2 ]
if len(brr) > 1: Mode = brr[1]
else: Mode = brr[0]
Range = Max - Min

s = str(Mean)+"\n"+str(Mid)+"\n"+str(Mode)+"\n"+str(Range)+"\n"
sys.stdout.write( s )