import sys
import heapq

N = int(input())
x = []

for i in range(N):
    num = int(sys.stdin.readline())
    if num != 0:
        heapq.heappush(x,(-num))
    else:
        try:
            print(-1 * heapq.heappop(x))
        except:
            print(0)