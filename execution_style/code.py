'''
Created on 2013-5-1

@author: Administrator
'''
from PIL import Image

im = Image.open("doll2.png")
print im
pixels = list(im.getdata())
print pixels
f = open("doll2.7z", "wb")
for i in pixels:
    f.write('%c' % i)