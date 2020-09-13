import sys

current_word = None
current_count = 0
word = None

#input comes from STDIN
for line in sys.stdin:
    #Remove trailing and leading white spaces.
    line = line.strip()
    #parse the input we got from mapper.py
    word, count = line.split('\t', 1)
    #convert count (currently a string to int)
    try:
        count = int(count)

    except ValueError:
        #Count was not a number, so silently ignore/ discard the line.
        continue

    if current_word == word:
        current_count += count
    else:
        if current_word:
            #Write result to STDOUT
            print('%s\t%s' % (current_word, current_count))
        current_count = count
        current_word = word

#Do not forget to output the last word if needed.
if current_word == word:
    print('%s\t%s' % (current_word, current_count))
    