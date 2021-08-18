from sys import stdin
a = b = c = 0
input = stdin.readline
n = int( input().rstrip() )
arr = []
for _ in range( n ):
    tmp = list( map(int, input().rstrip().split()) )
    arr.append( tmp )

def cntPaper( row, col, size ):
    global a, b, c
    if chkColor( row, col, size ):
        if arr[row][col] == -1: a += 1
        elif arr[row][col] == 0: b += 1
        else: c += 1
        return
    
    newSize = size//3
    
    cntPaper( row, col, newSize )
    cntPaper( row, col+newSize, newSize )
    cntPaper( row, col+2*newSize, newSize )

    cntPaper( row+newSize, col, newSize )
    cntPaper( row+newSize, col+newSize, newSize )
    cntPaper( row+newSize, col+2*newSize, newSize )
    
    cntPaper( row+2*newSize, col, newSize )
    cntPaper( row+2*newSize, col+newSize, newSize )
    cntPaper( row+2*newSize, col+2*newSize, newSize )
        
def chkColor( row, col, size ):
    color = arr[row][col]
    for i in range( row, row+size ):
        for j in range( col, col+size ):
            if color != arr[i][j]: return False
    return True

cntPaper( 0, 0, n )
print( a ); print( b ); print( c )
