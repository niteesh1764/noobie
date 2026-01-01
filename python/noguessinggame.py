import random 

lower_bound = int(input('What is the lower bound\n'))
upper_bound = int(input('What is the upper bound\n'))

random_number = int(random.uniform(lower_bound,upper_bound))

print('You will initially be getting 5 tries to guess the number\n')
tries = 5
print('Lets Start the game\n')
print('-------------------\n')
while(True):
    guess = int(input('What is your guess\n'))
    tries -=1
    if guess == random_number: 
        print('Congratulations, You guessed the number correctly\n')
        break
    elif guess > random_number:
        print('Try Again! You guessed too high.\n')
        print(f'You\'re Guesses: {tries}\n') 
    else:
        print('Try Again! You guessed too Low.\n')
        print(f'You\'re Guesses: {tries}\n')
    if(tries == 0):
        print('You\'ve exhausted all you\'re attempts\n')
        print('Better Luck Next Time\n')
        break 



