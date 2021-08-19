from sys import stdin
input = stdin.readline
n = int( input().rstrip() )
arr = list( map(int, input().split()) )
print( min(arr)*max(arr) )