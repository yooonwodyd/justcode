'''
1. 2개 무작위로 잡고
2. BFS로 최대값 구하고
3. 저장
'''

from collections import deque

def BFS(chick1,chick2):
    global N
    check = [False] * (N + 1)
    distance = [0] * (N + 1)
    check[chick1] = True
    check[chick2] = True
    que = deque()
    que.append(chick1)
    que.append(chick2)

    while que:
        dis = que.popleft()
        for i in tree[dis]:
            if check[i] == False:
                check[i] = True
                que.append(i)
                distance[i] = distance[dis] + 1

    count = 0
    for i in distance:
        count += i


    return count




N,M = map(int,input().split())

tree = [[]for _ in range(N+1)]
for i in range(M):
    a,b = map(int,input().split())
    tree[a].append(b)
    tree[b].append(a)

a,b
answer = 100000

for i in range(1,N+1):
    for j in range(i+1,N+1):
        d = BFS(i,j)
        if answer > d:
            a,b,answer = i , j, d

print(a,b,answer*2)


