#https://programmers.co.kr/learn/courses/30/lessons/12951
def solution(s):
    answer = ''
    s = s.lower()
    ex = s.split(' ')

    for i in ex:
        i = i.capitalize()

        answer += i + " "

    return answer[:-1]