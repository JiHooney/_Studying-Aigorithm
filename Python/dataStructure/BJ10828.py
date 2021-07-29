from sys import stdin
stack = []
next( stdin )
s = ""
for line in stdin:
    Order = line.split()
    
    if Order[0] == "push":
        stack.append( Order[1] )
    elif Order[0] == "pop":
        if stack: s += stack.pop()+"\n"
        else: s += "-1\n"
    elif Order[0] == "size":
        s += str( len(stack) )+"\n"
    elif Order[0] == "empty":
        if stack: s += "0\n"
        else: s += "1\n"
    elif Order[0] == "top":
        if stack: s += stack[-1]+"\n"
        else: s += "-1\n"
print( s )