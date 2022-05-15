board = []
word = []
imsi = 0
board_check = [[-1for a in range(6)]for b in range(6)]
answer = []
check = 'F'


def board_back():
    global board
    global word
    global check
    global board_check
    global imsi
    global answer
    global word_check
    jumsu = 0
    count = 0
    long_word = ''
    for j in range(0,len(word)):
        word_find(j,0)
        if imsi == 1:
            count += 1
            jumsu += jumsu_check(word[j])
            imsi = 0
            if len(long_word) < len(word[j]):
                long_word = word[j]
            elif len(long_word) == len(word[j]):
                aaaa = [long_word, word[j]]
                aaaa.sort()
                long_word = aaaa[0]
    answer.append([str(jumsu), long_word, str(count)])
    ##print(jumsu, long_word, count)




def word_find(j,spell):
    global board
    global board_check
    global word_check
    global word
    global imsi

    if imsi == 1:
        return

    for i in range(0,4):
        for k in range(0,4):
            if board[i][k] == word[j][spell] and board_check[i+1][k+1] == -1:
                if con_check(i,k,spell) == 'T' or spell == 0:
                    board_check[i + 1][k + 1] = spell
                    if spell == len(word[j]) - 1:
                        imsi = 1
                        word_check[j] = 'T'
                        board_check = [[-1 for a in range(6)] for b in range(6)]
                        return
                    word_find(j, spell + 1)
                    if imsi == 1:
                        return
                board_check[i+1][k+1] = -1
    return





def con_check(y,x,spell):
    y = y+1
    x = x+1
    global board_check
    if board_check[y-1][x+1] == spell-1 or board_check[y][x+1] == spell-1 or board_check[y+1][x+1] == spell-1 or board_check[y+1][x] == spell-1 or board_check[y+1][x-1] == spell-1 or board_check[y][x-1] == spell-1 or board_check[y-1][x-1] == spell-1 or board_check[y-1][x] == spell -1:
        return 'T'
    else:
        return 'F'


def jumsu_check(word):
    if len(word) <= 2:
        return 0
    elif len(word) <= 4:
        return 1
    elif len(word) == 5:
        return 2
    elif len(word) == 6:
        return 3
    elif len(word) == 7:
        return 5
    elif len(word) == 8:
        return 11



word_num = int(input())


for i in range(0,word_num):
    word.append(input())
input()
word_check = ['F' for i in range(len(word))]



board_num = int(input())
for i in range(0,board_num):
    for k in range(0,4):
        board.append(input())
    if i < board_num-1:
        input()
    board_back()
    board.clear()

for i in range(0,board_num):
    print(' '.join(answer[i]))

