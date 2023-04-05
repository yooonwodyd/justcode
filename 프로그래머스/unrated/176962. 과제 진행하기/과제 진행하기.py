from collections import deque


def solution(plans):
    ### 분으로 바꾸기
    for i in plans:
        minute = 0
        a = ''
        for j in i[1]:
            if j == ':':
                minute += int(a) * 60
                a = ''
            else:
                a += j
        minute += int(a)
        i[1] = minute
        i[2] = int(i[2])

    ## 과제를 시간순으로 정렬하기
    plans = sorted(plans, key=lambda x: x[1])
    
    
    ## 푼 과제는 answer에 넣기
    ## 풀고 남은 과제는 stack에 넣어두기
    ## 마지막까지 다 풀었다? -> stack에 넣어둔 과제들 순서대로 풀기
    ## 시간이 남았다? -> 다음 과제 미리해두기
    answer = []
    stack = []
    
    l = len(plans)
    
    for i in range(l):
        name,start,playtime = plans[i][0],plans[i][1],plans[i][2]
        if i == l-1:
            answer.append(name)
            while stack:
                name,start,playtime = stack.pop()
                answer.append(name)
            break
        else:
            if start + playtime > plans[i+1][1]:
                stack.append([name,start,playtime - (plans[i+1][1] - start)])
                
            elif start + playtime == plans[i+1][1]:
                answer.append(name)
                
            elif start + playtime < plans[i+1][1]:
                answer.append(name)
                remainedTime = plans[i+1][1] - start - playtime
                while stack:
                    if stack[-1][2] <= remainedTime:
                        remainedTime -= stack[-1][2]
                        answer.append(stack[-1][0])
                        stack.pop()
                    else:
                        stack[-1][2] -= remainedTime
                        remainedTime = 0
                        break
                
                    
                        
    

    return answer
