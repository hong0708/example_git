#https://programmers.co.kr/learn/courses/30/lessons/12981
def solution(n, words):
    answer = []
    num = 1
    while num < len(words):
        if words[num][0] != words[num - 1][-1]:
            break
        elif words[num] in words[0:num - 1]:
            break
        else:
            num += 1
    if num == len(words):
        answer.append(0)
        answer.append(0)
    else:
        answer.append(num % n + 1)
        answer.append(num // n + 1)

    return answer