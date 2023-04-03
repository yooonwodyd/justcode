import sys

N,M = map(int,sys.stdin.readline().split())

b_map = []


for i in range(N):
    b_map.append(list(map(int,sys.stdin.readline().rstrip().split())))



block_front = list(map(int,sys.stdin.readline().rstrip().split()))


for i in range(M):
    if block_front[i] != 0:
        for j in range(N):
            if b_map[j][i] != 0:
                b_map[j][i] = block_front[i]


block_side = list(map(int,sys.stdin.readline().rstrip().split()))

block_side.reverse()

for i in range(N):
    for j in range(M):
        if block_side[i] < b_map[i][j] and block_side[i] != 0:
            b_map[i][j] = block_side[i]


'''
주어진 조건을 만족했는지 체크하기
how? 
최대값이 같은지 확인 하기
'''
check_answer = True



for i in range(N):
    side_count = 0
    for j in range(M):
        if b_map[i][j] == block_side[i]:
            side_count += 1
    if side_count == 0 or block_side[i] == 0 and side_count != M:
        check_answer = False
for i in range(M):
    front_count = 0
    for j in range(N):
        if b_map[j][i] == block_front[i]:
            front_count += 1
    if front_count == 0 or (block_front[i] == 0 and front_count != N):
        check_answer = False


if check_answer:
    for i in b_map:
        print(*i)
else:
    print(-1)