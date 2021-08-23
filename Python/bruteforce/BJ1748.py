n = int(input())
s = len(str(n))
ans = 0
for i in range( 1, s ):
    ans += 9 * i * 10**(i-1)
print( ans + ( s * ( ( n - 10**(s-1) ) + 1 ) ) ) 