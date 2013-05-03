#!/usr/bin/python
# Author: Albus Shin
f = open('residue.txt', 'r')
print f
for line in f:
	print chr(int(line[39:])),
