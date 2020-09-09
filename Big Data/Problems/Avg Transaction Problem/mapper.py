import sys

for line in sys.stdin:
    line = line.strip()
    card, amount = line.split(',')
    
    print('%s \t%s' %(card, amount) )