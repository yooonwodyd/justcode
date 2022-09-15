
n = input()
bomb = input()
answer = []
count = 0
count_stack = []
stack = []
l = len(n)
bl = len(bomb)
for i in range(l):
    answer.append(n[i])
    if n[i] == bomb[count % bl]:

        stack.append(n[i])
        count += 1
    elif n[i] == bomb[0]:

        stack.append(n[i])
        count_stack.append(count)
        count = 1
    else:
        count = 0
        count_stack.clear()
    if count == bl:

        count = 0
        for k in range(bl):
            answer.pop()
        if count_stack:
            count = count_stack.pop()

result = ''.join(map(str, answer))

if result:
    print(result)
else:
    print("FRULA")