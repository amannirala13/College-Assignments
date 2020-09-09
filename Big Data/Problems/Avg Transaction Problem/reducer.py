import sys

cardSet ={}

for line in sys.stdin:
    
    line =  line.strip()
    card, amount = line.split()
    if(card in cardSet.keys()):
        cardSet[card].append(float(amount))
    else:   
        cardSet[card] = []
        cardSet[card].append(float(amount))
        
print(cardSet)

for card in cardSet.keys():
    print('%s \t%s'%(card, sum(cardSet[card]) / len(cardSet[card])))