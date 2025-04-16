package NumberGuesserJava;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;
public class NumberGuesserGUI {
    public NumberGuesserGUI(){
        //Random number generator
        Random random = new Random();
        //Frame/Window
        JFrame frame = new JFrame();
        frame.setBounds(500,250,600,400);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setTitle("Number Guesser Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //Number Guesser Title
        JLabel title = new JLabel("Number Guesser Game!");
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setBounds(140,10,400,100);
        frame.add(title);
        //Instruction
        JLabel instruction = new JLabel("Instruction: To play, just click the start button. Enjoy!");
        instruction.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        instruction.setBounds(80,50,500,100);
        frame.add(instruction);
        //Footer
        JLabel footer = new JLabel("Created by Chanyo3");
        footer.setFont(new Font("Times New Roman", Font.BOLD, 20));
        footer.setBounds(200,200,300,100);
        frame.add(footer);
        //Start Button
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
        startButton.setBounds(240,150,100,50);
        frame.add(startButton);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Variables
                int maxNumber;
                int minNumber;
                int tries;
                int randomNumber;
                //Let user input number of tries
                while(true){
                    while(true){
                        try{
                            String triesInput = JOptionPane.showInputDialog(null,"Input maximum tries: ","Maximum of tries", JOptionPane.QUESTION_MESSAGE).trim();
                            if(triesInput.isEmpty()){
                                JOptionPane.showMessageDialog(null,"Input blank, invalid");
                                continue;
                            }
                            tries = Integer.parseInt(triesInput);
                            if(tries <= 0){
                                JOptionPane.showMessageDialog(null, "Input number greater than 0");
                                continue;
                            }
                            break;
                        }
                        catch(NumberFormatException error){
                            JOptionPane.showMessageDialog(null,"Input integer/number only!");
                        }
                    }
                    while(true){
                        //Input Starting number
                        try{
                            String startNumber = JOptionPane.showInputDialog(null,"Input minumum number to random Number: ","Minimum Number",JOptionPane.QUESTION_MESSAGE).trim();
                            if(startNumber.isEmpty()){
                                JOptionPane.showMessageDialog(null,"Input is blank");
                                continue;
                            }
                            minNumber = Integer.parseInt(startNumber);
                            if(minNumber <= 0){
                                JOptionPane.showMessageDialog(null, "Input number greater than 0");
                                continue;
                            }
                            break;
                        }
                        catch(Exception error){
                            JOptionPane.showMessageDialog(null,"Input integer/number only!");
                        }
                    }
                    while(true){
                        //Let user input maximum number of random generator
                        try{
                            String endNumber = JOptionPane.showInputDialog(null,"Input maximum number to random Number: ","maximum Number",JOptionPane.QUESTION_MESSAGE).trim();
                            if(endNumber.isEmpty()){
                                JOptionPane.showMessageDialog(null,"Input is blank, Invalid");
                                continue;
                            }
                            maxNumber = Integer.parseInt(endNumber);
                            if(maxNumber <= minNumber){
                                JOptionPane.showMessageDialog(null,"Input number greater than the minimum number!");
                                continue;
                            }
                            break;
                        }
                        catch(Exception error){
                            JOptionPane.showMessageDialog(null,"Input integer/Number only!");
                        }
                    }
                    //Generate random number
                    randomNumber = (random.nextInt(maxNumber - minNumber)+minNumber);
                    //Let user guess the number
                    //tries counter variable
                    int tryCount = 1;
                    int guessNumber = 0;
                    while(tries >= tryCount){
                        try{
                            tryCount+=1;
                            String guessNumberString = JOptionPane.showInputDialog(null,"Input guessed number: ", "Guess Number",JOptionPane.QUESTION_MESSAGE).trim();
                            if(guessNumberString.isEmpty()){
                                tryCount-=1;
                                JOptionPane.showMessageDialog(null,"Input was empty, input again");
                            }
                            guessNumber = Integer.parseInt(guessNumberString);
                            if(guessNumber == randomNumber){
                                JOptionPane.showMessageDialog(null,"You guessed the right number!");
                                break;
                            }
                            else if(guessNumber <= minNumber){
                                JOptionPane.showMessageDialog(null,"Input number is less than guess number.");
                            }
                            else if(guessNumber >= maxNumber){
                                JOptionPane.showMessageDialog(null,"Input number is greater than guess number.");
                            }
                        }
                        catch(Exception error){
                            tryCount -=1;
                            JOptionPane.showMessageDialog(null,"Input integer/number only");
                        }
                    }
                    //End message
                    if(guessNumber != randomNumber){
                        JOptionPane.showMessageDialog(null,"You did not guessed the right number, nice try!");
                    }
                    String revelation = String.format("Random number was: %d",randomNumber);
                    JOptionPane.showMessageDialog(null,revelation);
                    JOptionPane.showMessageDialog(null,"Click START again to play again");
                    break;
                }
            }
        });
    }
    //Main Method
    public static void main (String[]args){
        //Try catch, displaying the whole written program
        try{
            NumberGuesserGUI object = new NumberGuesserGUI();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null,"Run error");
        }
    }
}