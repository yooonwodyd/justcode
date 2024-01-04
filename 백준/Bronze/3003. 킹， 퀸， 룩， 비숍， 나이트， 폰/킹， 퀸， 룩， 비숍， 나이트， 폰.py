pieces = [1,1,2,2,2,8]
rest_pieces = list(map(int,input().split()))
for i in range(6):
    pieces[i] -= rest_pieces[i]
print(*pieces)
