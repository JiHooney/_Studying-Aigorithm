import sys
readline = sys.stdin.readline

def main():
    str_s = readline()
    
    str_tail = []
    for i in range(len(str_s)-1):
        str_tail.append( str_s[i:] )
    
    str_tail.sort()
    
    for i in str_tail:
        print( i, end='' )
    

if __name__ == '__main__':
    main()