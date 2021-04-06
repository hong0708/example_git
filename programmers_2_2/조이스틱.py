name = "ABABAAAAABA"

alpa = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
        'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0']
answer = 0


def count(word):
    where = alpa.index(word)
    if where > 12:
        where -= 26
        where *= -1
    return where


change = []
for i in name:
    change.append(count(i))
print change

back = []
for i in range(len(change) - 1, -1, -1):
    back.append(change[i])
print back, change

answer += sum(change)

left = 0
right = 0

for i in range(1, len(change)):
    if change[i] != 0:
        left = i
        break
left = len(change) - left

for i in range(0,len(back)):
    if back[i] != 0:
        right = i
        break
right = len(change) - right -1

if right > left:
    answer += left
else:
    answer += right

print answer
