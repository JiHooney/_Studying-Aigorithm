import sys
readline = sys.stdin.readline

n = int( readline() )
A = set( readline().split() )
m = int( readline() )

ans = ""
for i in readline().split():
    if i in A: ans += "1\n"
    else: ans += "0\n" 
print( ans )