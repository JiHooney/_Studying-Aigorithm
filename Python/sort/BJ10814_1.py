from sys import stdin, stdout

arr = [ [] for _ in range(201) ]

for line in stdin.read().splitlines(True)[1:]:
    arr[ int(line.split()[0]) ].append(line)
    
stdout.write(''.join(''.join(u) for u in arr))
