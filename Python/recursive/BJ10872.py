from sys import stdin
input = stdin.readline
n = int( input() )

def recur( a ):
    if a <= 1:
        return 1
    return a * recur( a-1 )

print( recur(n) )