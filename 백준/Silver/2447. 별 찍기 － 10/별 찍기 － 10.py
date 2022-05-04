def star(num,x,y) :
    global Map
    x1 = x
    y1 = y

    num = num//3
    if num == 1:
        Map[x + 1][y + 1] = ' '
        return

    for y1 in range(y,y+num) :
        for x1 in range(x,x+num):
            Map[y1+num][x1+num] = ' '
    star(num,x,y)
    star(num, x+num, y)
    star(num, x+num*2, y)
    star(num, x, y+num)
    star(num, x+num*2, y+num)
    star(num, x, y+num*2)
    star(num, x+num, y + num * 2)
    star(num, x+num*2, y + num * 2)
    return

n = int(input())

Map = [["*" for i in range(n)]for i in range(n)]


star(n,0,0)

for i in range(n):
    for k in range(n):
        print(Map[i][k],end = '')
    print()