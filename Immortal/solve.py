'''
Created on 2013-5-21

@author: Albus
'''

import base64

encoded = "4uTX1eTV2NWxw9Wl0tTHxmHzyGTB9OfmQkNk89Hz+LTx4rjXoqMAAKO0paHh0qFB88a3xuKmEA=="
s = base64.b64decode(encoded, altchars = None);
print s
for c in s:
    i = ord(c)
    print hex(i)
print len(s)*8
f = open("solve.bin", "wb")
f.write(s)
f.close();