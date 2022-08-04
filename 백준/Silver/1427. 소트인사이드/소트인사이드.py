N = list(map(str,input()))

N_num = list(map(int,N))

N_num.sort(reverse = True)

print(*N_num,sep = '')

