N,M = map(int,input().split())


board = []
answer = []
for i in range(N):
    board.append(input())


for i in range(N-7):
    for k in range(M-7):
        countW = 0
        countB = 0
        for x in range(i,i+8):
            for y in range(k,k+8):
                if(x + y)%2 == 0:
                    if board[x][y] != 'W': countW += 1
                    if board[x][y] != 'B': countB += 1
                else:
                    if board[x][y] != 'B': countW += 1
                    if board[x][y] != 'W': countB += 1

        answer.append(countW)
        answer.append(countB)

print(min(answer))