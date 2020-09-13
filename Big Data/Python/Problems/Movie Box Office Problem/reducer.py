import sys

movie = []
genre = []
score = []

for line in sys.stdin:
    line = line.strip()
    m, g, s = line.split('\t')
    
    movie.append(m)
    genre.append(g)
    score.append(float(s))
        
        
print('Movie: ', movie)
print('Score: ', score)


genreAvg = {}
for i in range(0, len(genre)):
	if(genre[i] in genreAvg.keys()):
		genreAvg[genre[i]].append(float(i))
	else:
		genreAvg[genre[i]] = []
		genreAvg[genre[i]].append(float(i))

for i in genreAvg.keys():
	genreAvg[i] = sum(genreAvg[i]) / len(genreAvg[i])


print('Average: ', genreAvg)

for i in range (0, len(movie)):
    if(score[i] >= genreAvg[genre[i]]):
        print('%s \t%s \t%s'%(movie[i], genre[i],score[i]))