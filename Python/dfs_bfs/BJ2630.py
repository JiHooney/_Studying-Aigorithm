white = 0; blue = 0;

def cutPaper( row, col, size ):
    if chkCol( row, col, size ):
        if arr[row][col] == 0: white += 1
        else: blue += 1
        return
    
    newSize = size // 2;
    cutPaper(row, col, newSize)
    cutPaper(row, col+newSize, newSize)
    cutPaper(row+newSize, col, newSize)
    cutPaper(row+newSize, col+newSize, newSize)
    
def chkCol( row, col, size ):
    color = arr[row][col];
    
    for i in range( row, row+size ):
        for j in range( col, col+size ):
            if arr[i][j] != color: return False;
    return True;

n = int( input() )
arr = [ [0]*n for _ in range( n ) ]

cutPaper( 0, 0, n )

print( white ); print( blue )