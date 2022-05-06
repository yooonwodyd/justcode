def Z_num(N,a):

    if(N == 1):
        return a

    if a == 2**(N-1):
        return 2**(2*N-2)
    elif a > 2**(N-1):
        return 2**(2*N-2) + Z_num(N-1,a-2**(N-1))
    elif a < 2**(N-1):
        return Z_num(N-1,a)






N, r, c = map(int, input().split())

ans = Z_num(N,c) + 2 * Z_num(N,r)


print(ans)
