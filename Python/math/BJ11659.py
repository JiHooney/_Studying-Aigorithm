from itertools import accumulate
from sys import stdin

def sol( n, m ):
    tmp = map(int, input().split())
    arr = [0] + list( accumulate( tmp ) )
    
    for _ in range( m ):
        a, b = map(int, input().split())
        print( arr[b]-arr[a-1] )

if __name__ == '__main__':
    input = stdin.readline
    sol( *map(int, input().split()) )