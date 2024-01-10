dirX = [0, 0, -1, 1]
dirY = [1, -1, 0, 0]


def checkCanMove(field, stX, stY, N, M):
    queue = []
    queue.append((stX, stY))

    while queue:
        nowX, nowY = queue.pop()
        field[nowY][nowX] = 2
        for i in range(4):
            nextX = nowX + dirX[i]
            nextY = nowY + dirY[i]
            if 0 <= nextX < M and 0 <= nextY < N:
                if field[nextY][nextX] == 1:
                    queue.append((nextX, nextY))
    return




t = int(input())
for i in range(t):
    M, N, K = map(int, input().split())
    field = list([0] * (M) for _ in range(N))
    for i in range(K):
        x, y = map(int, input().split())
        field[y][x] = 1

    count = 0
    for y in range(N):
        for x in range(M):
            if field[y][x] == 1:
                count += 1
                checkCanMove(field, x, y, N, M)
    print(count)
## 인접한 배추로 이동후 true로 변경
