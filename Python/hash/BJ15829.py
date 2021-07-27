l = int(input()); s = input(); ans = 0; tmp = 1; m = 1234567891
for i in range(len(s)):
    ans = (ans + (ord(s[i]) - ord('a') + 1) * tmp) % m
    tmp = (tmp * 31) % m    
print(ans)
