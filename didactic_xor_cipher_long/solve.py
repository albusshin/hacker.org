'''
Created on 2013-5-14

@author: Albus
'''
string = "8776459cf37d459fbb7b5ecfbb7f5fcfb23e478aaa3e4389f378439aa13e4e96a77b5fc1f358439df36a4486a03e4381b63e5580a66c0c8ebd6d5b8aa13e459cf34e4d9fa67f02cf90714288a17f589abf7f5886bc705fcfbc700c96bc6b5ecfb7775f8cbc68499daa3f"

theList = []
while string != "":
    tmp = string[:2]
    string = string[2:]
    theList.append(int(tmp, 16))
    
keys = [211, 30, 44, 239]
outputStr = ""
for i, c in enumerate( theList ):
    print i, c
    c = c ^ keys[i%4]
    print i, c, chr(c)
    outputStr += chr(c)
print outputStr
#     print "%x" % theKey

    