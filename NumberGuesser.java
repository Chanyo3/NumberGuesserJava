//Import Scanner for user input
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
public class NumberGuesser {
    public static void main(String[]args){
        //Scanner and random object
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        //Variables for min and max number and boolean to keep the CLI running
        int minNumber = 0;
        int maxNumber = 0;
        boolean running = true;
        int randomNumber = 0;
        int tries = 0;
        //While loop to keep the program running
        while(running == true){
            System.out.println("Number guesser game");
            //Let user input minimum number
            while(true){
                    try{
                        //Let user input min and max number
                        System.out.print("Input minimum number: ");
                        minNumber = scan.nextInt();
                        if(minNumber <= 0){
                            System.out.println("Input number greater than 0/zero");
                            continue;
                        }
                        break;
                    }
                    catch(InputMismatchException error){
                        System.out.println("Input integer only!");
                        scan.next();
                    }
                }
            //Let user input maximum number
                while(true){
                    try{
                        //Let user input min and max number
                        System.out.print("Input maximum number: ");
                        maxNumber = scan.nextInt();
                        if(maxNumber <= minNumber){
                            System.out.println("Input number greater than the minimum Number");
                            continue;
                        }
                        break;
                    }
                    catch(InputMismatchException error){
                        System.out.println("Input integer only!");
                        scan.next();
                    }
                }
                //Generate random number
                randomNumber = random.nextInt(maxNumber - minNumber);
                //let user input maximum number of tries
                while(true){
                    try{
                        System.out.printf("Input maximum of tries: ");
                        tries = scan.nextInt();
                        if(tries <= 0){
                            System.out.println("Input number greater than 0!");
                            continue;
                        }
                        break;
                    }
                    catch(InputMismatchException error){
                        System.out.println("Input integer only!");
                        scan.next();
                    }
                }
                //Try counter
                int tryCounter = 1;
                int guessNumber = 0;
                //start of play
                while(tries >= tryCounter){
                    tryCounter+=1;
                    try{
                        System.out.print("Input guess number: ");
                        guessNumber = scan.nextInt();
                        if(guessNumber < randomNumber){
                            System.out.println("Random number is greater than guess number");
                            guessNumber = 0;
                        }
                        else if(guessNumber > randomNumber){
                            System.out.println("Random number is less than guess number");
                            guessNumber = 0;
                        }
                        else if (guessNumber == randomNumber) {
                            guessNumber = 0;
                            System.out.println("You guessed the right number!");
                            break;
                        }
                    }
                    catch(InputMismatchException error){
                        System.out.println("Input integer only!");
                        scan.next();
                    }
                }
            //Reveal random number
            System.out.printf("Random number was: %d\n",randomNumber);
            String playAgain = "";
            while(true){
                System.out.print("Do you want to play again?(Y/N) ");
                playAgain = scan.nextLine().trim();
                if(playAgain.equalsIgnoreCase("Y")){
                    break;
                }
                else if(playAgain.equalsIgnoreCase("N")){
                    running = false;
                    break;
                }
                else{
                    System.out.println("Input Y/N only!");
                }
            }
        }
        scan.close();
        System.out.println("Thanks for playing!");
    }
}