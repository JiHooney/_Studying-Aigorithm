import sys

n, m, b = map(int, input().split())

lists = []

for _ in range(n):
    lists.append(list(map(int, input().split())))
        
# κ°??₯ ??? μΈ΅μ κ΅¬ν¨
high = max(max(lists)) 
low = min(min(lists))
          
time = 9223372036854775807
height = 0

# κ°??₯ ??? μΈ΅μ? 0μΈ΅κΉμ§?? ?? ???κ²? ?? ? ?κ°κ΅¬?κΈ?
for k in range(high, low - 1, -1):
    x = 0  # x? ?Έλ²€ν λ¦¬μ ?£? λΈλ‘κ°μ
    y = 0  # y? ?Έλ²€ν λ¦¬μ? κΊΌλΌ λΈλ‘ κ°μ
    
    for i in range(n):
        for j in range(m):
            # κΈ°μ?μΈ΅λ³΄?€ λΈλ‘?΄ λ§μΌλ©? ?Έλ²€ν λ¦¬μ ?£? λΈλ‘κ°μ μ¦κ?
            if lists[i][j] > k: 
                x += lists[i][j] - k
            # κΈ°μ?μΈ΅λ³΄?€ λΈλ‘?΄ ? ?Όλ©? ?Έλ²€ν λ¦¬μ? κΊΌλΌ λΈλ‘κ°μ μ¦κ?
            else:
                y += k - lists[i][j]
    
    # ?Έλ²€ν λ¦¬μ ?£? λΈλ‘κ°μ + ?Έλ²€ν λ¦? - ??? λΈλ‘κ°μ
    if x + b - y < 0:
        continue
    
    # ??¬ μΈ΅μ ?κ°μ΄ ? ? μΈ΅λ³΄?€ ??Όλ©? timeκ³? heightλ₯? μ΄κΈ°??΄μ€??€.
    if (2 * x + y) < time:
        time = 2 * x + y
        height = k

print(time, height)

