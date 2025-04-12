#random number library
import random
print("Number Guesser")
confirm = True
while confirm == True:
    #Range of number
    startNumber = 0
    endNumber = 0
    while True:
        try:
            startNumber = int(input("Input starting range of Number to be generated: "))
            if startNumber <= 0:
                print("Input number greater than 0")
                continue
            endNumber = int(input("Input ending range of Number to be generated: "))
            if endNumber <= 0:
                print("Input number greater than 0")
                continue
            break
        except:
            print("Input number only!")
    #Generate random number
    randomNumber = random.randint(startNumber, endNumber)
    #Total Tries
    totalTries = 0
    while True:
        try:
            totalTries = int(input("Input total tries: "))
            if totalTries <= 0:
                print("Input number greater than 0")
                continue
            break
        except:
            print("Input number only")
    #Let user guess/Game starts
    tries = 1
    number = 0
    while tries <= totalTries:
        try:
            tries +=1
            number = int(input("Input number guess: "))
            if(number == randomNumber):
                print("You guessed the number!")
                break
            elif number < randomNumber:
                print("Random number is greater than that")
            elif number > randomNumber:
                print("Random number is greater than that")
        except:
            tries -=1
            print("Input number only!")
    #Display Failed if user failed to guess the right answer
    if tries == totalTries or number != randomNumber:
        print("You did not get the right number, number was %d"%(randomNumber))
    #Let user play again
    while True:
        tryAgain = input("Want to play again?(Y/N): ").strip().lower()
        if tryAgain == "y":
            continue
        elif tryAgain == "n":
            print("Thanks for playing")
            confirm = False
            break
        else:
            print("Input Y/N only!")