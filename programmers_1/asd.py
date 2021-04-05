answer = 1
w = 8
h = 12
a = 0
b = 0
if w > h:
    a = w
    b = h
else:
    a = h
    b = w
while b != 0:
    num = b
    b = a % b
    a = num
if b == 1:
    answer = w * h - w - h + 1
else:
    answer = w * h - (w + h - num)
print  answer