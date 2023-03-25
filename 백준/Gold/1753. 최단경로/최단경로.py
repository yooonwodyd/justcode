'''
1. 시작 노드를 기준으로 각 노드의 최소 비용을 저장
2. 방문하지 않은 노드 중에서 가장 가중로이 적은 노드를 선택
3. 해당 노드를 거쳐서 특정한 노드로 가는 경우를 고려하여 최소 비용을 갱신
4. 반복.
'''

import sys
import heapq

INF= sys.maxsize
V, E = map(int,sys.stdin.readline().split())
# 정점의 개수 V 와 간선의 개수 E
K = int(input())
# 시작점 K

dp = [INF]*(V+1)
# 가중치를 정해두는 리스트
heap = []
graph = [[] for _ in range(V + 1)]

def Dijkstra(start):
    #가중치 테이블에서 시작 정점에 해당하는 가중치는 0으로 초기화
    dp[start] = 0
    heapq.heappush(heap,(0, start))

    #힙에 원소가 없을 때 까지 반복.
    while heap:
        wei, now = heapq.heappop(heap)

        #현재 테이블과 비교하여 불필요한(더 가중치가 큰) 튜플이면 무시.
        if dp[now] < wei:
            continue

        for w, next_node in graph[now]:
            #현재 정점 까지의 가중치 wei + 현재 정점에서 다음 정점(next_node)까지의 가중치 W
            # = 다음 노드까지의 가중치(next_wei)
            next_wei = w + wei
            #다음 노드까지의 가중치(next_wei)가 현재 기록된 값 보다 작으면 조건 성립.
            if next_wei < dp[next_node]:
                #계산했던 next_wei를 가중치 테이블에 업데이트.
                dp[next_node] = next_wei
                #다음 점 까지의 가증치와 다음 점에 대한 정보를 튜플로 묶어 최소 힙에 삽입.
                heapq.heappush(heap,(next_wei,next_node))

#초기화
for _ in range(E):
    u, v, w = map(int, input().split())
    #(가중치, 목적지 노드) 형태로 저장
    graph[u].append((w, v))


Dijkstra(K)
for i in range(1,V+1):
    print("INF" if dp[i] == INF else dp[i])