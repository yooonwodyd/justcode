import sys

while True:
    histogram = list(map(int, sys.stdin.readline().split()))
    histogram.append(0)
    max_area = 0
    Height = []
    a = 1
    if histogram[0] == 0:
        break

    Height.append((histogram[1],1))   ## 세로, 가로
    for i in range(2,len(histogram)):
        if histogram[i-1] < histogram[i]:
            Height.append([histogram[i],i])
        elif histogram[i-1] > histogram[i]:
            while Height:
                if Height[-1][0] <= histogram[i]:
                    break
                else:
                    area = Height[-1][0] * (i - Height[-1][1])
                    a = Height[-1][1]
                    if area > max_area:
                        max_area = area
                    Height.pop()
            Height.append([histogram[i], a])
    print(max_area)
    histogram.clear()
    Height.clear()