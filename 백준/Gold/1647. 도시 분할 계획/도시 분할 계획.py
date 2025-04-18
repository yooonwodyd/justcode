def union(a,b):
    a = find(a)
    b = find(b)
    if a >= b:
        parent[a] = b
    else:
        parent[b] = a
    return

def find(a):
    if a != parent[a]:
        parent[a] = find(parent[a])
    return parent[a]

##  집의 개수 N, 길의 개수 M
N,M = map(int,input().split())
graph = []
parent = [i for i in range(N+1)]
for i in range(M):
    a,b,w = map(int,input().split())
    graph.append((a,b,w))
    graph.append((b,a,w))

answer = 0
rootValue = 0

graph.sort(key = lambda x: x[2])
for a,b,w in graph:
    if find(a) != find(b):
        answer += w
        rootValue = max(w,rootValue)
        union(a,b)

print(answer - rootValue)