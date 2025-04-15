import heapq
def dijkstra(st,graph,n):
    dist = [100000 * 1000 +1 for i in range(N+1)]
    pq = []
    heapq.heappush(pq,(st,0))
    dist[st] = 0
    while pq:
        now_node,now_dist = heapq.heappop(pq)
        for next_node,next_weight in graph[now_node]:
            next_dist = now_dist + next_weight
            if dist[next_node] > next_dist:
                dist[next_node] = next_dist
                heapq.heappush(pq,(next_node,next_dist))

    return dist[1:]

## 노드,간선,목적지
N,M,X = map(int,input().split())

to_graph = {i : [] for i in range(N+1)}
from_graph = {i : [] for i in range(N+1)}

for _ in range(M):
    st,end,weight = map(int,input().split())
    to_graph[st].append((end,weight))
    from_graph[end].append((st,weight))
to_dist = []
from_dist = []
to_dist,from_dist = dijkstra(X,to_graph,N), dijkstra(X,from_graph,N)

print(max(t+f for t,f in zip(to_dist,from_dist)))
