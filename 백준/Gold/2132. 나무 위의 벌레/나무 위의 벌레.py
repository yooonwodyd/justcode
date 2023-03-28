import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline


def dfs(now, f):
    global prob, visited, fruit, tree
    if f in prob:
        prob[f].add(now)
    else:
        prob[f] = {now}
    visited[now] = True
    for p in tree[now]:
        if not visited[p]:
            dfs(p, f + fruit[p])


n = int(input())
fruit = [0] + list(map(int, input().split()))
tree = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

prob = dict()
visited = [False] * (n + 1)
dfs(1, fruit[1])

dia_end = list(prob[max(prob.keys())])


prob = dict()
for p in dia_end:
    visited = [False] * (n + 1)
    dfs(p, fruit[p])

max_fruite = max(prob.keys())
dia_end += list(prob[max_fruite])
print(max_fruite, min(dia_end))
