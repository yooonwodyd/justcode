from collections import deque



def BFS():
    while location:
        x,y = location.popleft()
        for i in range(4):
            pre_x = x + dx[i]
            pre_y = y + dy[i]
            if 0 <= pre_x < M and 0 <= pre_y < N and maze[pre_y][pre_x] == 1:
                maze[pre_y][pre_x] = maze[y][x] + 1
                location.append((pre_x,pre_y))
    return




N,M = map(int,input().split())

maze = [list(map(int,input())) for i in range(N)]

location = deque()
location.append((0,0))
dx = [0,0,-1,1] #상하좌우
dy = [-1,1,0,0]

BFS()
print(maze[N-1][M-1])


