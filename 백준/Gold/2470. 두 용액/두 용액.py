n = int(input())

num = list(map(int,input().split()))

num2 = []
for i in num:
    if i < 0:
        num2.append([-i,1])
    else:
        num2.append([i,0])

num2.sort()

a = 0
b = 0
answer1 = 0
answer2 = 0

for i in range(n):
    if num2[i][1] == 1:
        num2[i][0] = -num2[i][0]


min = num2[0][0] + num2[1][0]


for i in range(n-1):
    a = num2[i][0]
    b = num2[i+1][0]

    if abs(a + b) <= abs(min):
        min = a + b
        answer1 = a
        answer2 = b

if answer1 < answer2:
    print(answer1,answer2,sep = ' ')
else:
    print(answer2, answer1, sep=' ')








