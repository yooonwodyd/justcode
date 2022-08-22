import sys




N,M = map(int,input().split())
name_list = {}
dcbo= []
for i in range(N+M):
    name = sys.stdin.readline().strip()
    if not name in name_list:
        name_list[name] = 1
    else:
        dcbo.append(name)

dcbo.sort()
print(len(dcbo))
for i in dcbo:
    print(i)
