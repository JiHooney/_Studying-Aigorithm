while True:
    n = input()
    if n == "0": break
    ans = "yes"
    for i in range(len(n) // 2):
        if n[i] != n[len(n) - i - 1]: 
            ans = "no"
            break
    print(ans)
