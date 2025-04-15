def find(a):
    if not isinstance(social[a],int):
        social[a] = find(social[a])
        return social[a]
    return a

def union(a,b):
    if a != b:
        social[a] += social[b]
        social[b] = a
    return social[a]

global social
T = int(input())
for i in range(T):
    F = int(input())
    social = {}
    for _ in range(F):
        name_a,name_b = input().split()
        social.setdefault(name_a,1)
        social.setdefault(name_b,1)
        p_a = find(name_a)
        p_b = find(name_b)
        print(union(p_a,p_b))