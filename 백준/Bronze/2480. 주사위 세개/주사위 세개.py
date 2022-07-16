num = []

a = list(map(int, input().split()))

count = 0
count_num = 0

a.sort()

count_num = max(a)


if a[0] == a[1]:
    count_num = a[0]
    count += 1

if a[1] == a[2]:
    count_num = a[1]
    count += 1

if count == 1:
    print(1000+count_num*100)

elif count == 2:
    print(10000+count_num*1000)

elif count == 0:
    print(count_num * 100)
