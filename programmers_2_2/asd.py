name = 'AABAAA'
back = list(name)
back.reverse()
for i in range(len(back)):
    if back[i] != "A":
        where = i
        break
print len(back) - where

