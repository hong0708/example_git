#https://programmers.co.kr/learn/courses/30/lessons/12980
def solution(n):
    ans = 0

    while n > 0:
        ans += n % 2
        n = n // 2

    return ans