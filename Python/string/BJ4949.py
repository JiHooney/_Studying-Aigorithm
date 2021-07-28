def solve( line ):
    stack = []
    for i in line:
        if i in "([": 
            stack.append( i )
        elif i == ")":
            if not stack or stack.pop() != "(":
                print( "no" )
                break
        elif i == "]":
            if not stack or stack.pop() != "[":
                print( "no" )
                break
        elif i == ".":
            if stack: 
                print( "no" )
                break
            else:
                print( "yes" )
                break

if __name__ == "__main__":
    import sys
    while( True ):
        line = sys.stdin.readline().rstrip()
        if line == ".": break
        else: solve( line )