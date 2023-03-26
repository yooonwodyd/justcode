import sys
import heapq

N = int(sys.stdin.readline())
min_q,max_q = [],[]
## min_q는 max_q 의 root 보다 큰 값들 만들어감
for i in range(N):
    su = int(sys.stdin.readline().strip())
    if len(min_q) == len(max_q):
        heapq.heappush(max_q,(-su,su))
    else:
        heapq.heappush(min_q,(su,su))

    if min_q and min_q[0][1] < max_q[0][1]:
        imsi,median = heapq.heappop(max_q)[1], heapq.heappop(min_q)[1]
        heapq.heappush(min_q,(imsi,imsi))
        heapq.heappush(max_q,(-median,median))
    print(max_q[0][1])
