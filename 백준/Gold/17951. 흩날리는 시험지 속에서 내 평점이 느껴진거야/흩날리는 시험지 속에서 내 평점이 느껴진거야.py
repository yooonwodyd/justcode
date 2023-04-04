import sys

'''
그룹에서 최소 넘어야하는 점수가 정해졌을때, 그룹의 수가 적다면?
-> 절반 아래에서 다시 탐색
-> 많다면? 절반 위에서 다시 탐색
'''
N,K = map(int,sys.stdin.readline().split())
## 시험지 개수 , 그룹의 수
start,end = 0,100000 * 20

papers = list(map(int,sys.stdin.readline().split()))
answer = 0
while start <= end:
    middle = (start + end) // 2
    count = 0
    jumsu = 0
    for i in papers:
        jumsu += i
        if jumsu >= middle:
            count += 1
            jumsu = 0

    if K <= count:
        answer = middle
        start = middle + 1
        end = end
    elif K > count:
        start = start
        end = middle - 1

print(answer)


