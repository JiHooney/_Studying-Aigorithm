arr = [ i for i in range(1, 10001)]

for i in range(1, 10001):
    num = 0
    
    if len(str(i)) == 1:
        num = i + i
        arr.remove(num)
        continue
    
    tmp = 0
    for j in range(len(str(i))):
        tmp += int(str(i)[j])
    num = i + tmp
    try:
        arr.remove(num)
    except:
        continue
    
print("\n".join(str(a) for a in arr))
