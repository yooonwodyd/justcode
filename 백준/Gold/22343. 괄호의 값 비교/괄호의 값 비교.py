import sys

t=int(sys.stdin.readline())

for i in range(t):
    a=sys.stdin.readline().rstrip()
    l=len(a)
    v=1
    ans=0
    ans2=0
    for j in range(l):
        if a[j]=='(':
            v*=2
        elif a[j-1]=='(' and a[j]==')':
            ans+=v//2
            v//=2
        else:
            v//=2
    a=sys.stdin.readline().rstrip()
    l=len(a)
    v=1
    for j in range(l):
        if a[j]=='(':
            v*=2
        elif a[j-1]=='(' and a[j]==')':
            ans2+=v//2
            v//=2
        else:
            v//=2
    if ans>ans2:
        print('>')
    elif ans<ans2:
        print('<')
    else:
        print('=')