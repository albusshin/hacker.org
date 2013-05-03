#!/usr/bin/python
# Author: Albus Shin

memo = {0:0, 1:1}
def fib(n):
    global memo
    if not n in memo:
        memo[n] = fib(n-1) + fib(n-2)
    return memo[n]

i = 6
while fib(i) - fib(i-4) < 1000000000000:
	i += 1
	
i -= 2
print i
