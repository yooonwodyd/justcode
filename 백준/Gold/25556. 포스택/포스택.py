'''
1. 4개의 스택 만들기
2. 첫번째 스택부터 while문 돌리기 , 순열 A가 빌 때 까지. or 넣는게 불가능해질때까지
3. 만약 스택이 비어있다면 넣는다.
4. 만약 스택에 담긴 수 보다 넣고자 하는 수가 크면 넣는다.
5. 작으면 다음 스택으로
-> 추가로 수들이 붙어있어야 된다.
'''

import sys

from collections import deque



N_stack =[[] for i in range(4)]


sys.stdin.readline()

N = deque(sys.stdin.readline().split())
now_num = 0
count = 0


while N:
    now_num = int(N.popleft())
    count = 0
    while count < 4:
        if not N_stack[count]:
            N_stack[count].append(now_num)
            break
        elif N_stack[count][-1] < now_num:
            N_stack[count].append(now_num)
            break
        count += 1
    if count == 4:
        break

if count < 4:
    print("YES")
else:
    print("NO")

