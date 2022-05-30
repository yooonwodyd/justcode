n = int(input())

member = list(map(int,input().split()))


member.sort()

answer = 0
for i in range(n):
    answer += sum(member[0:i+1])

print(answer)