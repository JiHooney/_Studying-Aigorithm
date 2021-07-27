import sys
readline = sys.stdin.readline


def main():
    n = int(readline())
    arr = [ 0 for _ in range(10001) ]
    
    for _ in range(n):
        arr[ int(readline()) ] += 1
        
    for i in range(len(arr)):
        for j in range(arr[i]):
            print(i)

            
if __name__ == '__main__':
    main()
