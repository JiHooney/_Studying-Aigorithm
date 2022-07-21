N = 5
lost = [2, 4]
reserve = [1, 3, 5]

#두 배열에 공통요소를 빼준다.
reserve_new = set(reserve)-set(lost)
lost_new = set(lost)-set(reserve)

#여벌 가져온 학생 순회하면서 
#앞뒤 학생 중 분실된 학생 있는지 조사
#있으면 체육복 빌려주고 분실된 학생 배열에서 제외
for i in reserve_new:
    if i-1 in lost_new:
        lost_new.remove(i-1)
        
    elif i+1 in lost_new:
        lost_new.remove(i+1)
        
answer = N - len(lost_new)

print( answer )
