'''
Created on 2013-5-18

@author: Albus
'''


import os
import shutil
import zipfile
from tempfile import mkdtemp

z = zipfile.ZipFile("manyfiles.zip")
# for c in z.namelist():
#     theStr = z.read(c, pwd = None);
#     print theStr
#     if theStr[:4] != "Find":
#         print theStr
#         print c

outputFile = open("solve.png", "wb")
theList = z.namelist();
theList.sort(cmp=None, key=None, reverse=False);
for item in theList:
    theStr = z.read(item, pwd = None)
    outputFile.write('%c' % len(theStr))
outputFile.close()

# outputFile = open("file.png", "wb")
# for i, item in enumerate(theList):
#     byte = item[-6:-4]
#     writtingIn = int(byte, 16)
#     print byte
#     outputFile.write('%c' % writtingIn)
#     print i
# outputFile.close()
# print len(theList)
