def solution(play_time, adv_time, logs):
    to_second = lambda t: int(t[0:2])*60*60 + int(t[3:5]) * 60 + int(t[6:8])
    
    play_second = to_second(play_time)
    adv_second = to_second(adv_time)
    watcher_num = [0] * (play_second + 1)
    
    for log in logs:
        st,end = log.split("-")
        st_second,end_second = to_second(st),to_second(end)
        watcher_num[st_second] += 1
        watcher_num[end_second] -= 1
    
    ## 누적합
    for i in range(1,play_second + 1):
        watcher_num[i] += watcher_num[i-1]
        
    ## 최다 시청 구간
    max_watcher_num = sum(watcher_num[:adv_second])
    ad_st_time = 0
    now_watcher_num = max_watcher_num
    for i in range(1,(play_second) - adv_second):
        now_watcher_num -= watcher_num[i]
        now_watcher_num += watcher_num[i + adv_second]
        if now_watcher_num > max_watcher_num:
            max_watcher_num = now_watcher_num
            ad_st_time = i + 1
    
    ast = ad_st_time
    answer = f"{ast//3600:02d}:{ast%3600//60:02d}:{ast%60:02d}"
    return answer