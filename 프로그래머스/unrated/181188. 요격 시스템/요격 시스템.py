def solution(targets):
    targets.sort(key = lambda x :(x[0],x[1]))
    
    count = 0
    m_range = [-1,100000001]
    for i,bum in enumerate(targets):
        st,end = bum
        if m_range[0] < st:
            m_range[0] = st
        if m_range[1] > end:
            m_range[1] = end
        if m_range[1] <= st:
            count += 1
            m_range[0] = st
            m_range[1] = end
  
    return count + 1