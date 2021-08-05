n = int( input() ); 
a = 0; b = 0
for i in range( 2, n+1 ):
    num = i
    while num%2==0:
        num /= 2
        a += 1
    while num%5==0:
        num /= 5
        b += 1
print( min(a, b) )