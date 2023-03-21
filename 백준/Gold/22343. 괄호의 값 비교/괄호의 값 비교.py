
def calcuFx(a):

    stack = []
    count = 0
    while count != len(a):
        if a[count] == '(':
            stack.append(a[count])
        elif stack and a[count] == ')' and stack[-1] == '(':
            stack[-1] = 1

        elif len(stack) > 1 and a[count] == ')' and stack[-1] != '(' and stack[-2] == '(':
            ## 숫자 뒤에 괄호가 나왔다면 숫자 * 2
            stack[-2] = stack[-1] * 2
            del stack[-1]
        while True:
            if len(stack) > 1 and stack[-2] != '(' and stack[-1] != '(':
                ## 길이가 2보다 큰데 스택의 맨 위에가 둘다 숫자라면
                stack[-2] += stack[-1]
                del stack[-1]
            else:
                break
        count += 1

    return stack[0]






T = int(input())

for i in range(T):
    A = calcuFx(input())
    B = calcuFx(input())
    if A == B:
        print('=')
    elif A < B:
        print("<")
    elif A > B:
        print('>')
