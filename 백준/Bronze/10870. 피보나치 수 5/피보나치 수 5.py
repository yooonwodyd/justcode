def pivo(a,b,count,num):
    if count == num - 2:
        return a + b
    next = a + b
    a = b;
    return pivo(a,next,count+1,num)





count = int(input())

if count == 0:
    print(0)
elif count == 1:
    print(1)
else:
    print(pivo(0,1,0,count))
