from collections import deque

snake = deque([])
snake.append((0, 0))
N = int(input())  ## 보드판
K = int(input())  ## 사과의 개수
dx = [1, 0, -1, 0]  ## 머리방향이 우, 하 상 좌
dy = [0, 1, 0, -1]  ## 왼쪽으로 L = -1 오른쪽 D = +1
cur_time = 0
cur_dir = 0
cur_head = [0, 0]  ## x 좌표, y 좌표
count = 0
map_ = [[0 for i in range(N)] for i in range(N)]
check = 0
map_[0][0] = 2
spin_time = deque([])
dir = deque([])

for i in range(K):
    r, c = map(int,input().split())
    map_[r - 1][c - 1] = 1

for i in range(int(input())):
        a, b = input().split()
        spin_time.append(int(a))
        dir.append(b)

while True:
    count += 1

    y = snake[-1][0] + dy[cur_dir % 4]
    x = snake[-1][1] + dx[cur_dir % 4]


    if(y < 0 or y == N) or (x < 0 or x == N):

        check = 1
        break
    if map_[y][x] == 0:
        snake.append((y,x))
        map_[y][x] = 2
        map_[snake[0][0]][snake[0][1]] = 0
        snake.popleft()

    elif map_[y][x] == 1:
        map_[y][x] = 2
        snake.append((y,x))

    elif map_[y][x] == 2:

        check = 1
        break

    if spin_time and spin_time[0] == count:
        if dir[0] == 'L':
            cur_dir -= 1
            dir.popleft()
            spin_time.popleft()

        elif dir[0] == 'D':
            cur_dir += 1
            dir.popleft()
            spin_time.popleft()



print(count)












