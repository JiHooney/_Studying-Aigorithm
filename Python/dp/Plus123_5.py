t = int(input())

div = 1000000009
limit = 100000

d = [ [0] * 4 for i in range(limit + 1) ]
d[1][1] = 1
d[2][2] = 1
d[3][1] = 1
d[3][2] = 1
d[3][3] = 1

for i in range(4, limit + 1):
    for j in range(1, 4):
        if j == 1: d[i][j] = (d[i - 1][2] + d[i - 1][3]) % div
        elif j == 2: d[i][j] = (d[i - 2][1] + d[i - 2][3]) % div
        elif j == 3: d[i][j] = (d[i - 3][1] + d[i - 3][2]) % div
        d[i][j] %= div

for i in range(0, t):
    n = int(input())
    sum = 0
    
    for j in range(1, 4):
        sum += d[n][j]
        sum %= div
    
    print(sum)
