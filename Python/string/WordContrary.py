n = int(input())

for i in range(n):
    s = []
    s = input().split()
    
    for i, v in enumerate(s):
        print(v[len(v)::-1], end=" ")
