import sys

cc = {}

for line in sys.stdin:
    line = line.strip()
    
    cardNo, transaction = line.split()

    if cardNo in cc:
        cc[cardNo].append(float(transaction))

    else:
        cc[cardNo] = []
        cc[cardNo].append(float(transaction))

for cardNo in cc.keys():
    print('%s\t%s' %(cardNo, sum(cc[cardNo])))