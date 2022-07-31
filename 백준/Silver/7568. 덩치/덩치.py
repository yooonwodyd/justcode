n = int(input())

bulk = []
bulk_s = []

for i in range(n):
	a,b = map(int,input().split())
	bulk.append((a,b))
	bulk_s.append((a,b))

bulk_s.sort(key = lambda x: -x[0])



for i in bulk:
	count = 1
	for k in bulk_s:
		if i[0] < k[0] and i[1] < k[1]:
			count = count + 1
	print(count, end = ' ')





