from collections import deque

def DFS(V):
    global q
    global Num
    global Num_check

    while Num[V]:
        q = Num[V].popleft()
        if Num_check[q] == False:
            print(q,end = ' ')
            Num_check[q] = True
            DFS(q)


    return

def BFS(V):
    global q_BFS
    global Num_2
    global Num_check

    while Num_2[V]:
        a = Num_2[V].popleft()
        if Num_check[a] == False:
            q_BFS.append(a)
            Num_check[a] = True
            print(a,end = ' ')

    while q_BFS:
        BFS(q_BFS.popleft())
    return



    return
N, M ,V = map(int,input().split())


kkk = [[] for i in range(N+1)]
Num = [deque()for i in range(N+1)]
Num_check = [False for i in range(N+1)]
Num_2 = [deque()for i in range(N+1)]

for i in range(M):
    a, b = map(int,input().split())
    kkk[a].append(b)
    kkk[b].append(a)


for i in range(N+1):
    kkk[i].sort()
    for k in range(0,len(kkk[i])):
        if kkk[i]:
            Num[i].append(kkk[i][k])
            Num_2[i].append(kkk[i][k])



q = V
print(V,end = ' ')
Num_check[V] = True
DFS(V)
print()


Num_check = [False for i in range(N+1)]

print(V, end=' ')
Num_check[V] = True
q_BFS = deque()
BFS(V)

