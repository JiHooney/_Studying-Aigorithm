from sys import stdin
input = stdin.readline
e, s, m = map(int, input().split())
cnt = 1; ee = 1; ss = 1; mm = 1;
while True:
    if ee==e and ss==s and mm==m: break
    cnt += 1; ee += 1; ss += 1; mm += 1;
    if ee == 16: ee = 1
    if ss == 29: ss = 1
    if mm == 20: mm = 1
print( cnt )