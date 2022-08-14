from collections import deque



card = deque( [i+1 for i in range(int(input()))])
while len(card) != 1:
    card.popleft()
    card.append(card[0])
    card.popleft()

print(card[0])



