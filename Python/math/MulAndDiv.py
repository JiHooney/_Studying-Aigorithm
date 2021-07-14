a1, a2 = map( int, input().split() )

s = []  #소수담는 리스트
s.append(2)
for i in range( 3, max(a1, a2)+1 ):
    for j in range( len(s) ):
        if i % s[j]==0:
            break
        if j==len(s)-1:
            s.append( i )
            
re1 = re2 = 1
t1 = a1
t2 = a2

i=0
while i<len(s) and ( s[i]<=a1 or s[i]<=a2 ):
    if t1%s[i]==0 and t2%s[i]==0:
        t1 = t1//s[i]
        t2 = t2//s[i]
        re1 *= s[i]
        i = -1
    i += 1
        
re2 = (a1//re1) * (a2//re1) * re1

print( re1 )
print( re2 )