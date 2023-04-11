
from collections import deque

def crash(height,direct , Len):
    if direct == 'left':
        for i in range(Len):
            if cave[height][i] == 'x':
                cave[height][i] = '.'
                check_cluster(i,height)
                break
    else:
        for i in range(Len -1,-1,-1):
            if cave[height][i] == 'x':
                cave[height][i] = '.'
                check_cluster(i,height)
                break
    return 0

def check_cluster(x,y):
    for i in range(4):
        dx,dy = dir[i]
        if 0 <= x + dx < C and 0 <= y + dy < R:
            check_under(x+dx,y+dy)
    return;


def check_under(x,y):
    global R,C
    under_stack = []
    check_cave = [[True for i in range(C)] for i in range(R)]
    que = deque()
    que.append((x,y))

    if cave[y][x] != 'x':
        return

    while que:
        x,y = que.pop()

        if y == R - 1:
            return
        check_cave[y][x] = False

        if cave[y+1][x] == '.':
            under_stack.append((x, y))

        for i in range(4):
            dx,dy = dir[i]
            pre_x ,pre_y = x+dx,y+dy
            if 0 <= pre_x < C and 0 <= pre_y < R:
                if check_cave[pre_y][pre_x] == True and cave[pre_y][pre_x] == 'x':
                    que.append((pre_x,pre_y))
    min = R - 1
    for i,k in under_stack:
        count = 0
        pre_height = k + 1
        while pre_height <= R - 1:
            if cave[pre_height][i] == 'x' and check_cave[pre_height][i] == True:
                break
            pre_height += 1
            count += 1
        if count < min:
            min = count


    down(under_stack,min,check_cave)
    return

def down(under_stack,count,check_cave):
    check_down = []
    for i,k in under_stack:
        if i not in check_down:
            check_down.append(i)
            for j in range(R - 1,-1,-1):
                if j + count <= R - 1 and check_cave[j][i] == False:
                    cave[j+count][i] = cave[j][i]
                    cave[j][i] = '.'
    return





## y ,x
R,C = map(int,input().split())

cave = [list(input())for i in range(R)]



N = int(input())
stick_height = input().split()


stick = ['','left','right']
turn = 1

## 상좌우하

dir = [(0,-1),(-1,0),(1,0),(0,1)]


for i in stick_height:
    crash(R - int(i), stick[turn],C)
    turn *= -1
for i in range(R):
    for k in range(C):
        print(cave[i][k],end='')
    print()









