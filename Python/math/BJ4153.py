while True:
    s = list(map(int, input().split()))
    if s[0] == 0: break
    s.sort()
    
    if(s[0] ** 2 + s[1] ** 2 == s[2] ** 2): print("right")
    else: print("wrong")
