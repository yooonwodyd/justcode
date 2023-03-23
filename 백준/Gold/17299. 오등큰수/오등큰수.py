'''
1. 오큰수는 어떻게 풀었는가?
오큰수에서 중요한 것. 수가 커질 때는 더하고,작아질 때는 더하지 않고 stack에 쌓아두는것
그리고 수가 커지면 스택에 쌓여있던 수들과 비교하는 것.
2. 오등큰수에서 추가된 조건?
-> 큰수 -> 등장 횟수로

how? 일단 배열을 한 번 돌면서 count 체크
다음 수의 count가 stack[-1]의 count 보다 작다면 stack에 다음 수 추가하기
다음 수의 count가 현재의 count 보다 많다면 answer에 값 추가하고 stack을 pop한 뒤에 또 비교
'''


import sys

N = int(sys.stdin.readline())

A = list(map(int,sys.stdin.readline().split()))

A_count = [0] * 1000001
Answer = [-1] * N
stack = []
stack.append(0)

for i in A:
    A_count[i] += 1 ## 수열 A의 원소가 등장한 횟수 기록

for i in range(1,N):
    while stack and A_count[A[stack[-1]]] < A_count[A[i]]:
        Answer[stack.pop()] = A[i]
    stack.append(i)

print(*Answer)

