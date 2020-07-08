#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'gradingStudents' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts INTEGER_ARRAY grades as parameter.
#

def gradingStudents(grades):
    for i, item in enumerate(grades):
        if grades[i] >= 38 and grades[i]%5 != 0:
            j = grades[i]
            while(j%5!=0):
                j+=1
            if j-grades[i] < 3:
                grades[i] = j
    return grades
            
if __name__ == '__main__':
    grades_count = int(input("Count").strip())

    grades = []

    for p in range(grades_count):
        grades_item = int(input("Element").strip())
        grades.append(grades_item)

    result = gradingStudents(grades)
    
    print(result)
