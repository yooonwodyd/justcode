n = int(input())
weight = list(map(int,input().split()))

weight.sort()



hap = 1
for i in weight:
    if hap < i:
        break
    hap += i

print(hap)
