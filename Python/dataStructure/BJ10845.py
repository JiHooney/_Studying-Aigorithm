from sys import stdin
que = []
next( stdin )

for line in stdin:
    Order = line.split()

    if Order[0]=="push":
        que.append( Order[1] )
    elif Order[0]=="pop":
        if que: print( que.pop(0) )
        else: print( "-1" )
    elif Order[0]=="size":
        print( len(que) )
    elif Order[0]=="empty":
        if que: print( "0" )
        else: print( "1" )
    elif Order[0]=="front":
        if que: print( que[0] )
        else: print( "-1" )
    elif Order[0]=="back":
        if que: print( que[-1] )
        else: print( "-1" )