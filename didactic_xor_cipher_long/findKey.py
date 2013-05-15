'''
Created on 2013-5-15

@author: Albus
'''
cList = [0x87, 0x76, 0x45, 0x9c]
keys = [0x00, 0x00, 0x00, 0x00]
for i, c in enumerate(cList):
    if i == 0:
        print c
        s = c ^ keys[i]
        while chr(s) != 'T':
            keys[i] += 1
            s = c ^ keys[i]
    elif i == 1:
        print c
        s = c ^ keys[i]
        while chr(s) != 'h':
            keys[i] += 1
            s = c ^ keys[i]
    elif i == 2:
        print c
        s = c ^ keys[i]
        while chr(s) != 'i':
            keys[i] += 1
            s = c ^ keys[i]
    elif i == 3:
        print c
        s = c ^ keys[i]
        while chr(s) != 's':
            keys[i] += 1
            s = c ^ keys[i]
            
print keys
