from collections import deque

d = [(-1,0),(1, 0), (0,-1),(0,1)]

def bfs():
    global Map
    day = 1
    while q:
        y, x = q.popleft()

        for k in range(len(d)):
            dx = x + d[k][0]
            dy = y + d[k][1]
            if 0 <= dx < X and 0 <= dy < Y:
                if Map[dy][dx] == 0:
                    Map[dy][dx] = Map[y][x] + 1
                    day = Map[dy][dx]
                    q.append((dy,dx))

    return day





X, Y = map(int, input().split())


Map = [list(map(int,input().split())) for _ in range(Y)]

q = deque()
a = True
for i in range(0,Y):
    for k in range(0,X):
        if Map[i][k] == 1:
            q.append((i,k))


Max = bfs()
a = True

for i in range(0,Y):
    for k in range(0,X):
        if a == False:
            break
        if Map[i][k] == 0:
            print(-1)
            a = False

if a == True:
    print(Max-1)
