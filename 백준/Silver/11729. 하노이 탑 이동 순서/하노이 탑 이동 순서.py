
def Hanoi(n, start, end, med) :
    if n == 1:
        print("%d %d" % (start,end))

    else:

        Hanoi(n-1,start,med,end)
        print("%d %d" % (start,end))
        Hanoi(n-1,med,end,start)





n = int(input())
print(2**n-1)
Hanoi(n, 1 , 3 ,2)
