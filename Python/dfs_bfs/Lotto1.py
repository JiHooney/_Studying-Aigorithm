from itertools import combinations

lotto = []
k = []

while True:
    tmp = [ x for x in map(int, input().split() ) ]
    if tmp[0] == 0:
        break
    k.append( tmp[0] )
    del tmp[0]
    
    lotto.append( tmp )
    
    
for k in range( 0, len(k) ):
    result = list(combinations( lotto[k], 6 ) )
    for i in range( 0, len(result) ):
        for j in range( 0, len(result[i] ) ):
            print( result[i][j], end=" " )
        print( end="\n" )
    print()
