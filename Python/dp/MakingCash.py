n, m = map(int, input().split())
arr = []

dp = [10001] * (m + 1)

for i in range(0, n):
    arr.append(int(input()))

dp[0] = 0

for i in range(n):
    for j in range(arr[i], m + 1):
        dp[j] = min(dp[j], dp[j - arr[i]] + 1)

if dp[m] == 10001:
    print("-1")
else:
    print(dp[m])
