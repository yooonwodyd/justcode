import sys

N = int(sys.stdin.readline())
for i in range(N):
    n = int(sys.stdin.readline())
    lw = list(map(int,sys.stdin.readline().rstrip().split()))
    stick = []
    for i in range(0,len(lw),2):
        stick.append((lw[i],lw[i+1]))

    stick = sorted(stick,key = lambda x:(x[0],x[1]))
    fail_stick = []
    s_stick = []
    count = 1
    answer = 1
    while True:
        count = 1
        while True:
            if count == len(stick):
                break
            if stick[count][1] < stick[count-1][1]:
                fail_stick.append(stick[count])
                del stick[count]
                count -= 1
            count += 1
        if not fail_stick:
            break
        stick = fail_stick
        fail_stick = []
        answer += 1
    print(answer)








