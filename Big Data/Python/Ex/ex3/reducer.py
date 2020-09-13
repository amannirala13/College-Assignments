import sys

gender_age = {}

for line in sys.stdin:

    line = line.strip()

    gender, age = line.split()

    if gender in gender_age:
        gender_age[gender].append(int(age))

    else:
        gender_age[gender] = []
        gender_age[gender].append(int(age))
print(gender_age)
# Reducer

for gender in gender_age.keys():
    avg_age = sum(gender_age[gender]) / len(gender_age[gender])
    print('%s\t%s' % (gender, avg_age))