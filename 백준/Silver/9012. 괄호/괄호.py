
N = int(input())

for a in range(N):
    PS = input()

    opP = 0
    clP = 0
    for i in PS:
        if i == '(':
            opP += 1
        elif i == ')' and opP > 0:
            opP -= 1
        else:
            opP = 1
            break

    if opP == 0:
        print("YES")
    else:
        print("NO")