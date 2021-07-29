def chkVps( line ):
    st = []
    for i in line:
        if i in "(": st.append( i )
        elif not st and i == ")": return "NO"
        elif st and i == ")": st.pop()
        
    if not st: return "YES"
    else: return "NO"

if __name__ == "__main__":
    import sys
    line = sys.stdin.readline
    
    t = int( line() )
    sb = ""
    for _ in range( t ):
        sb += chkVps( line() )+"\n"
        
    print( sb )