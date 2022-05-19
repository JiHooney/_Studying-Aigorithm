import sys
input = sys.stdin.readline

N = int(input())
meetings = [ [0]*2 for _ in range(N) ]

for i in range(N):
    a, b = map(int, input().split())
    meetings[i][0] = a
    meetings[i][1] = b
    
meetings.sort( key=lambda x: (x[1], x[0]) )

result = 0
prev_end_time = 0

for i in range(0, N):
    if prev_end_time <= meetings[i][0]:
        result += 1
        prev_end_time = meetings[i][1]
        
print( result )