import sys

gender_age = {}                                 # Creating an empty dictionary to store gender and age as key value pairs.

for line in sys.stdin:

    line = line.strip()                         # Removing white spaces from each line.

    gender, age = line.split()                  # Splitting gender and age from each line.

    if gender in gender_age:
        gender_age[gender].append(int(age))     # If gender(key) is already in the dictionary, then we append the age(value) to the 
                                                # list corresponding to the gender(key).

    else:
        gender_age[gender] = []                 # If key isn't there we create a blank list and append the age to it and store it 
                                                # corresponding to the key in the dictionary.
        gender_age[gender].append(int(age))
print(gender_age)                               # For testing the result in gender_age dictionary.

# Reducer
# We display the max of the ages for each age.
for gender in gender_age.keys():
    max_age = max(gender_age[gender]) 
    print('%s\t%s' % (gender, max_age))
    