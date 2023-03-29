from collections import deque

T = int(input())

for i in range(T):
    N,M = map(int,input().split())
    arr = input().split()
    que = deque()
    level_stack = []
    for i in range(N):
        level_stack.append(arr[i])
        que.append((i,arr[i]))
    count = 0
    level_stack.sort()

    while que:
        doc,level = que.popleft()
        if level == level_stack[-1]:
            count += 1
            level_stack.pop()
            if doc == M:
                print(count)
                break
        else:
            que.append((doc,level))




