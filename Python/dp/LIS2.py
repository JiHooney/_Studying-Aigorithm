n = int(input())
a = [0] + list(map(int, input().split()))
d = [0] * (n + 1)
d[1] = 1

for i in range(2, n + 1):
    d[i] = 1
    for j in range(1, i):
        if a[i] > a[j] and d[i] <= d[j]:
            d[i] = d[j] + 1

print(max(d))
