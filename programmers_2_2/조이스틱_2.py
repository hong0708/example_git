name = "ABABAAAAABA"

alpa = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
        'W', 'X', 'Y', 'Z']
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
answer += sum(change)

where = 0
while change:
    front, back = 1, 1
    while change[where + front] != 0 or change[where - back] != 0:
        if change[where + front] != 0:
            answer += front
            where = where + front
        else:
            answer += back
            where = where - back
        back += 1
        front += 1
print answer