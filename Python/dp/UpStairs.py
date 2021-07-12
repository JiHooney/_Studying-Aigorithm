n = int( input() )

#계단점수담을배열과 dp계산결과담을 배열 초기화
s = [0]*(n+1)
dp = [0]*(n+1) 

for i in range( 1, n+1 ):
    s[i] = int( input() )
    
dp[1] = s[1]
if n>=2: 
    dp[2] = dp[1] + s[2]
    
for i in range(3, n+1):
    dp[i] = max( dp[i-2]+s[i], dp[i-3]+s[i-1]+s[i] )

print( dp[n] )