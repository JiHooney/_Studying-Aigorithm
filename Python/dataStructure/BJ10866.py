from sys import stdin
deq = []
next( stdin )

for l in stdin:
    Order = l.split()
    
    if Order[0]=="push_front":
        if deq: deq.insert(0, Order[1] )
        else: deq.append( Order[1] )
        
    if Order[0]=="push_back":
        deq.append( Order[1] )
    
    if Order[0]=="pop_front":
        if deq: print( deq.pop(0) )
        else: print( -1 )
    
    if Order[0]=="pop_back":
        if deq: print( deq.pop() )
        else: print( -1 )
    
    if Order[0]=="size":
        print( len(deq) )
    
    if Order[0]=="empty":
        if deq: print( 0 )
        else: print( 1 )
    
    if Order[0]=="front":
        if deq: print( deq[0] )
        else: print( -1 )
    
    if Order[0]=="back":
        if deq: print( deq[-1] )
        else: print( -1 )