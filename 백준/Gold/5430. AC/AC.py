import sys
from collections import deque
T = int(sys.stdin.readline())


for i in range(T):
    s = 1
    p = sys.stdin.readline()
    n = int(input())
    check = True
    l = deque(sys.stdin.readline().rstrip()[1:-1].split(","))
    if n == 0:
        l = deque()

    for j in p:
        if j == 'R':
            s *= -1
        elif j == 'D':
            if len(l) < 1:
              print('error')
              check = False
              break
            elif l:
                if s == 1:
                    l.popleft()
                elif s == -1:
                    l.pop()
    if check == False:
        continue
    if s == -1:
        l.reverse()
    print('[',end='')
    print(",".join(l),end=']')
    print()




