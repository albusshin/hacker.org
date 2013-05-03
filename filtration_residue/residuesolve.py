#!/usr/bin/python
# Author: Albus Shin

f = open("checkresidue", "r")
s = ""
for lines in f:
	string = lines[:7]
	for c in string:
		if c == "0":
			s += "11"
		elif c == "1":
			s += "010"
		elif c == "2":
			s += "011"
		elif c == "3":
			s += "10"
		elif c == "4":
			s += "00"
print s
while s != "":
	t = s[:8]
	print chr(int(t, 2)),
	s = s[8:]
