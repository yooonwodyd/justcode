def C(N):
	for i in range(N):
		if i + sum(map(int,str(i))) == N:
			return i
			break

	return 0

print(C(int(input())))
