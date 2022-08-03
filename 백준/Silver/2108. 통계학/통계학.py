import math
from collections import Counter

N = int(input())

a = []
for i in range(N):
    a.append(int(input()))

a.sort()
mode_dic = Counter(a)
mode = mode_dic.most_common(2)




print(round(sum(a) / len(a)))
print(a[len(a)//2])


if len(a) != 1 and mode[0][1] == mode[1][1]:
    mode.sort()
    print(mode[1][0])
else:
    print(mode[0][0])

print(max(a)-min(a))




