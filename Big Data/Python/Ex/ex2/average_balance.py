import sys

age_balance = {}                    #empty dictionary will be used to store age and balance pairs. 

# Partitioners
for line in sys.stdin:              # We traverse each line

    line = line.strip()             # Remove whitespace characters from each line
    age, balance = line.split()

    # We check if the age is already in the dictionary, if there, we just append the balance to the age mapping to balance list.
    # The dictionary looks somewhat like this, age_balance = {34 : [3400, 4500], 38 : [3200, 3210]}
    if age in age_balance:
        age_balance[age].append(int(balance))

    # If the age is not there, we create an empty list for the age and append it to the age key.
    # The dictionary looks somewhat like this, age_balance = {34 : [3400, 4500], 38 : [3200, 3210], 42 : [4000]}
    else:
        age_balance[age] = []
        age_balance[age].append(int(balance))

# Reducer

# We write the reducer code to the same program, we traverse the dictionary and then we calcute the average and print them to the console.
for age in age_balance.keys():
    ave_bal = sum(age_balance[age]) / len(age_balance[age])
    print('%s\t%s' % (age, ave_bal))