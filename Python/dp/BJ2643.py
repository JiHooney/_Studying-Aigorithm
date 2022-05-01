N = int(input())

papers = []

for _ in range(N):
    w, h = map( int, input().split() )
    papers.append( (max(w,h), min(w,h)) )
    
papers.sort()

dp = [0]*N

for i in range(0, N):
    dp[i] = 1
    
    for j in range(0, i):
        if papers[i][0] >= papers[j][0] and papers[i][1] >= papers[j][1] and dp[i] < dp[j]+1:
            dp[i] = dp[j] + 1
            
print( max(dp) )
    


