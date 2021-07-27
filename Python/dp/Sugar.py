n = int(input())
d = [5000] * (n + 1)
if n <= 5:
    if n == 3 or n == 5: 
        print(1)
    else:
        print(-1)
else: 
    d[3] = 1
    d[5] = 1
    for i in range(6, n + 1):
        d[i] = min(d[i - 3] + 1, d[i - 5] + 1)

    if d[i] > 5000:
        print(-1)
    else:
        print(d[n])
