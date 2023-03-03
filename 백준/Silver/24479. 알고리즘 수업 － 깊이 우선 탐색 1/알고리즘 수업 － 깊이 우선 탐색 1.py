import sys
sys.setrecursionlimit(10**6)

global count
count = 0

'''R은 시작 정점'''
def DFS(R):
    global count
    if arr_check[R] == True:
        count += 1
        arr_count[R] = count
        arr_check[R] = False
        for i in arr[R]:
            DFS(i)
    else:
        return


N,M,R = map(int,sys.stdin.readline().split())


arr_count = [0 for i in range(N+1)]
arr_check = [True for i in range(N+1)]
arr = [[]for i in range(N+1)]
for i in range(M):
    a,b =map(int,sys.stdin.readline().split())
    arr[a].append(b)
    arr[b].append(a)


for i in arr:
    i.sort()


DFS(R)

for i in range(1,N+1):
   print(arr_count[i])

