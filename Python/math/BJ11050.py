n, k = map(int, input().split())
d = list([0] * (n + 1))
d[1] = [1, 1]
for i in range(2, n + 1):
    d[i] = list([0] * (i + 1))
    for j in range(0, i + 1):
        if j == 0 or j == i: d[i][j] = 1 
        else: d[i][j] = d[i - 1][j - 1] + d[i - 1][j] 
print(d[n][k])
