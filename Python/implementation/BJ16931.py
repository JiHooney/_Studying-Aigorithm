n, m = map(int, input().split())
arr = [ [0, 0, 0, 0] ]

for i in range(1, n + 1):
    arr.append([0] + list(map(int, input().split())))

sum = 0
for i in range(1, n + 1):
    for j in range(1, m + 1):
        sum += 2 + arr[i][j] * 4

for i in range(1, n + 1):
    for j in range(1, m):
        sum -= min(arr[i][j], arr[i][j + 1]) * 2
        
for i in range(1, m + 1):
    for j in range(1, n):
        sum -= min(arr[j][i], arr[j + 1][i]) * 2
        
print(sum)
