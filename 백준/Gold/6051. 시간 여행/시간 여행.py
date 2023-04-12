import sys

N = int(sys.stdin.readline().rstrip())

stack = [[] for _ in range(80010)]

for i in range(1,N+1):
    q = sys.stdin.readline().rstrip()
    if q[0] == 'a':
        stack[i].append(q[2:])
    elif q[0] == 's' and stack:
        del stack[i][-1]
    elif q[0] == 't':
        stack[i] = stack[int(q[2:])-1].copy()
    if not stack[i]:
        print(-1)
    else:
        print(stack[i][-1])
    stack[i+1] = stack[i].copy()
