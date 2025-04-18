import sys
sys.setrecursionlimit(10000)
def find(a):
    if parent[a] != a:
        parent[a] = find(parent[a])
    return parent[a]

def union(a,b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    if a >= b:
        parent[a] = b
        candy_bundle[b] += candy_bundle[a]
        children[b] += children[a]
    else:
        parent[b] = a
        candy_bundle[a] += candy_bundle[b]
        children[a] += children[b]
    return

N,M,K = map(int,input().split())
candy_bundle = list(map(int,input().split()))
candy_bundle.insert(0,0)
children = [1 for i in range(N+1)]


parent = [i for i in range(N+1)]
for i in range(M):
    a,b = map(int,input().split())
    union(a, b)


dp = [0 for i in range(K)]

for i in range(1,N+1):
    if(parent[i] != i):
        continue
    for k in range(K-1,children[i]-1,-1):
        dp[k] = max(dp[k],dp[k - children[i]] + candy_bundle[i])

print(max(dp))