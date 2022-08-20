input()
N_card = input().split()
map = {}
for i in N_card:
    if not i in map:
        map[i] = 1
    else:
        map[i] += 1
input()
M_card = input().split()
for i in M_card:
    if i in map:
        print(map[i],end = ' ')
    else:
        print(0, end = ' ')

