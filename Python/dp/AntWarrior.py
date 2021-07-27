n = int(input())
r = list(map(int, input().split()))
dp = [0] * n

dp[0] = r[0]
dp[1] = max(r[0], r[1])

for i in range(2, n):
    dp[i] = max(dp[i - 1], dp[i - 2] + r[i])

print(dp[n - 1])
