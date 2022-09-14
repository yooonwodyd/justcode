
n = int(input())

tower = list(map(int,input().split()))
t_stack = []
t_stack.append(n-1)
answer = [0] * n

for i in range(n-1, 0,-1):
    while t_stack and tower[i-1] >= tower[t_stack[-1]]:
        answer[t_stack.pop()] = i
    t_stack.append(i-1)
print(*answer)



