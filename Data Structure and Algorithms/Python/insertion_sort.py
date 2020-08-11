# -*- coding: utf-8 -*-
"""
Created on Tue Aug 11 14:20:30 2020

@author: amann
"""

def isort(data):
    for i in range (1,len(data)):
        flag = data[i]
        pos = i
        while pos > 0 and data[pos-1] > flag:
            data[pos] = data[pos-1]
            pos = pos-1    
        data[pos] = flag
    return data

def printData(data):
    print(data)
        
def acceptData():
    data = []
    try:
        while True:
            data.append(int(input("Enter element: ")))
    except:
        isort(data)
        printData(data)

print('INFO >>>> Enter any value other than an integer if you finished entering the values of the list')
acceptData()