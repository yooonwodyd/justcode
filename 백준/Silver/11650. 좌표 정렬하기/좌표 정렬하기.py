N = int(input())

N_list = []
for i in range(N):
    N_list.append(list(map(int,input().split())))

N_list.sort(key = lambda x:(x[0],x[1]))

for i in N_list:
    print(*i)

