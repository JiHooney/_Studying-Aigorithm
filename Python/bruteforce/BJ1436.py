n = int(input())
num = 666
cnt = 1

while(cnt != n):
    num += 1
    if str(num).find("666") != -1: cnt += 1
print(num)
