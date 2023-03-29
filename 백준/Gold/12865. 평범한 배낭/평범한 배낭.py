import sys


N,K = map(int,sys.stdin.readline().split())
## 물품의 수, 버틸 수 있는 무게

things = [[0 for _ in range(K+1)] for _ in range(N+1)]
'''
1. 최대 100,000의 크기를 가진 배열을 만든다.
2. 해당 배열을 물품의 수 만큼 만든다. 
-> why? 물품을 돌면서 생기는 그때그때의 최대값을 저장하기 위해서 + 중복되지 않기 위해
3. 만약 배열의 무게가 현재 물품의 무게 보다 높다면 해당 물품의 무게 or 해당물품의 무게 + 남는 물품의 무게의 최대값
중에서 높은 것을 선택한다.
'''

w = [(0,0)]

for i in range(N):
    W,V = map(int,sys.stdin.readline().split())
    w.append((W,V))



for i in range(1,N+1):
    weight,value = w[i]

    for k in range(K+1):
        if weight <= k:
            things[i][k] = max(things[i-1][k],value + things[i-1][k-weight])
        else:
            things[i][k] = things[i-1][k]



print(things[N][K])






