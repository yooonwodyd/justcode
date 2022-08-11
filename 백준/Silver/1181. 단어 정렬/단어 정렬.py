n = int(input())
dic = []
for i in range(n):
    a = input()
    dic.append((a,len(a)))
sort_dic = sorted(dic, key = lambda x:  (x[1],x[0]))

result = list(dict.fromkeys(sort_dic))


for i in range(len(result)):
    print(result[i][0])
