#https://programmers.co.kr/learn/courses/30/lessons/12924
def solution(n):
    answer = 1
    a = 2
    x = 5

    while x > 1:
        x = (n - (a * (a - 1)) / 2) / a
        if x % 1 == 0:
            answer += 1
        a += 1
    return answer