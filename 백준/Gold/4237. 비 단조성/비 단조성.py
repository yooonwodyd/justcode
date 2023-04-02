import sys

T = int(sys.stdin.readline())


state = ['', '>' , '<']

for i in range(T):
    n = list(map(int,sys.stdin.readline().strip().split()))
    max_b = 0
    now_b = 0
    now_state = 1
    '''
    1. 리스트를 돌면서 state의 상태와 일치한다면 now_b에 +1을 하고 now_state에 -1 을 곲하낟.
    2. state의 상태와 일치하지 않는다면, now_b와 max_b를 비교하고 , 
    now_b와 state의 상태를 0,1으로 만든다.
    '''
    for j in range(2,len(n)):
        if n[j-1] < n[j] and state[now_state] == '<':
            now_b += 1
            now_state *= -1
        elif n[j-1] > n[j] and state[now_state] == '>':
            now_b += 1
            now_state *= -1

    if now_b > max_b:
        max_b = now_b


    print(max_b+1)


