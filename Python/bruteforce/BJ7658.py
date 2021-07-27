n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))
    
for i in range(n):
    sum = n
    for j in range(n):
        if i == j: continue
        if arr[i][0] >= arr[j][0] or arr[i][1] >= arr[j][1]: sum -= 1            
    print(sum, end=" ")
