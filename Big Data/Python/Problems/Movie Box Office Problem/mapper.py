import sys

for line in sys.stdin:
    
    line = line.strip()
    
    try:
     movie, genre, score = line.split(',')   
    except ValueError:
        line = line.replace(',', ' ', line.count(',')-2)
        movie, genre, score = line.split(',')
    print('%s \t%s \t%s'%(movie, genre, score))
        