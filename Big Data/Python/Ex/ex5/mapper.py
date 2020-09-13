import sys

card_transact = {}

for line in sys.stdin:
    line = line.strip()
    
    data = line.split(',')
    
    print('%s\t%s' % (data[0], data[1]))
    
