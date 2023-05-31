
from collections import deque

###지점의 개수, 출발지점, a의 도착지점, B의 도착지점, 지점 사이의 예상 택시요금
def solution(n, s, a, b, fares):
    ### 내가 갔던 장소 체크, 택시 요금, 해당 지점 까지의 최소 택시 요금
    check_all = [True for _ in range(n+1)]
    taxi_map = [[] for _ in range(n+1)]

    ### 일단 시작지점에서 다익스트라를 돌린다. 돌린 결과를 list 형태로 반환한다.
    ### 해당 list를 하나 식 탐색한다.
    ### 현재 노드에서 다익스트라를 돌렸을 때 의 값을 추가로 구한다.

    for i in fares:
        taxi_map[i[0]].append((i[1],i[2]))
        taxi_map[i[1]].append((i[0],i[2]))
    que = deque()

    ### 현재시작지점과, 현재까지 같이 이동한 비용
    que.append(s)
    answer = 100001*201

    ### 전체 맵에 대한 다익스트라를 돌린다. -> 
    ### cost_all 에는 시작점에서 다른 지점까지 가는 최소비용이 들어있다.
    cost_all = dijkstra(s,n,taxi_map)
    cost_a_list = dijkstra(a,n,taxi_map)
    cost_b_list = dijkstra(b,n,taxi_map)    
    
    while que:
        pre_s = que.popleft()
        cost_a = cost_a_list[pre_s]
        cost_b = cost_b_list[pre_s]

        if answer > cost_a + cost_b + cost_all[pre_s]:
            answer = cost_a + cost_b + cost_all[pre_s]
        check_all[pre_s] = False

        for i in taxi_map[pre_s]:
            if check_all[i[0]] == True:
                que.append(i[0])
    return answer


def dijkstra(s,n,taxi_map):
    ### 시작점, 현재까지의 이동, 비용지도
    check_ab_map = [True for _ in range(n+1)]
    cost_map = [100001 * 201 for _ in range(n+1)]
    cost_map[s] = 0
    dj_que = deque()
    dj_que.append(s)
    while dj_que:
        pre_s = dj_que.popleft()
        for i in taxi_map[pre_s]:
            if cost_map[i[0]] > cost_map[pre_s] + i[1]:
                cost_map[i[0]] = cost_map[pre_s] + i[1]
                dj_que.append(i[0])
        check_ab_map[pre_s] = False
    return cost_map