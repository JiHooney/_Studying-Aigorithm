N, M, K = input().split(" ")
N = int(N)
M = int(M)
K = int(K)

nums = input().split(" ")
for i in range( 0, N ):
    nums[i] = int( nums[i] )

sum = 0
maxNum = max( nums )
nums.remove( maxNum )
maxNum2 = max( nums )

# 리스트안에 최대값이 중복일 때
for i in range( 0, N-1 ):
    if maxNum == nums[i]:
        sum = maxNum * M
        break;

if sum == 0:
    for i in range( 1, M+1 ):
        if i % K == 0:
            sum += maxNum2
        else:
            sum += maxNum

print( sum )