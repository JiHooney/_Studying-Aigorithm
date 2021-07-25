import sys
n = int( input() )
tmp = set()
for i in range( n ):
    tmp.add( input() )
    
arr = list(tmp)
arr.sort( key=len )
print( "\n".join( arr ) )