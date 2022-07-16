hour, minute = map(int, input().split())


cooking_time = int(input())

cook_end_time = (hour * 60 + minute + cooking_time) % 1440

print(cook_end_time // 60,cook_end_time % 60)



