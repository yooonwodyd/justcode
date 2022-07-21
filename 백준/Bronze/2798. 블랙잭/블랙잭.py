N , M = map(int,input().split())
card = []

card = (list(map(int, input().split())))

card.sort()
max = 0
for i in range(0,N):
    for k in range(i+1,N):
        for j in range(k+1,N):
            num = card[i] + card[j] + card[k]
            if num <= M and max < num:
                max = num
            elif num > M:
                break

print(max)
