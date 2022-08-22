import sys
import heapq


N = int(input())
cal_n = []
for i in range(N):
    card_size = int(sys.stdin.readline())
    heapq.heappush(cal_n,card_size)

answer = 0
while len(cal_n) > 1:
    a = heapq.heappop(cal_n) + heapq.heappop(cal_n)
    answer += a
    heapq.heappush(cal_n,a)

print(answer)


