import sys

def change_wh(bill):
    arr = [100 * 2, 100 * 2 + 9900 * 3, 100 * 2 + 9900 * 3 + 990000 * 5]

    if bill <= arr[0]:
        return bill // 2
    if bill <= arr[1]:
        return 100 + (bill - arr[0]) // 3
    if bill <= arr[2]:
        return 10000 + (bill - arr[1]) // 5

    return 1000000 + (bill - arr[2]) // 7


def change_bill(wh):
    arr = [100, 10000, 1000000]

    if wh < arr[0]:
        return wh * 2
    if wh < arr[1]:
        return 100 * 2 + (wh - 100) * 3
    if wh < arr[2]:
        return 100 * 2 + 9900 * 3 + (wh - 10000) * 5
    return 100 * 2 + 9900 * 3 + 990000 * 5 + (wh - 1000000) * 7

def binary_search(start,end, target):
    total_wh = end

    while True:
        my_wh = (start + end) // 2
        neighbor_wh = total_wh - my_wh

        diff = change_bill(neighbor_wh) - change_bill(my_wh)

        if diff == B:
            return change_bill(my_wh)

        if diff > B:
            start = my_wh + 1
        else:
            end = my_wh - 1

while True:
    A, B = map(int,input().split())

    if A + B == 0:
        break


    wh = change_wh(A)   ## 이웃을 포함한 총 전기 wh

    print(binary_search(1, wh, B))





