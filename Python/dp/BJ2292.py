n = int(input())
d = [0, 1]
i = 1
while n > d[i]:
    d.append(d[i] + (6 * i))
    i += 1
    
print(i)
