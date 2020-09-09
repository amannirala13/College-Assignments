import sys

#input comes from STDIN (standard input), i.e type file.txt brings the content of the file to the terminal, and we read it
for line in sys.stdin:

    #remove leading and trailing whitespaces.(\n)
    line = line.strip()

    #split the line into words.
    words = line.split()

    #increase counter.
    for word in words:
        #write the result to stdout 
        #what we output here will be the input to the reduce step, i.e input to reducer.py
        #tab-delimited; the trivial wordcount is 1
        #Note mapper is not computing the word occurrences sum.
        print('%s\t%s' %(word, 1))
