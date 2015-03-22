//Susan Wang
//2-4
package hangman;
import java.io.*;
import java.util.*;

public class Hangman {

    public static void main(String[] args) throws IOException {
        HangmanClass player = new HangmanClass("","",""); //myWord is nothing, user guess is nothing and number of blanks is nothing before initialization of myWord
        player.setLives(8); //max amount of failed attempts allowed is 8
        player.initializeUsedLetters(); //initializes "" to array of used letters by default
        player.findWord(); //generates random word
        player.setBlanks(); //sets the "_" needed
        player.userGuess(); //lets user input guess
        player.checkIsAlphabetical(); //checks if user input is alphabetical
        player.isLetterUsed(); //check if letter that user inputs has already been used
        player.addToUsedLettersArray(); //if it is a vaild letter, the letter is stored into an array
        player.updateBlanks(); //updates the "_" (significant changes made if user guesses right)
        System.out.println("");
        player.setNewBlanks(); //displays the updated "_"
        while(player.getLives()>0 && player.getMaxTries()>0) { //repeats while user has chances to guess and have not got all the letters
            player.userGuess();
            player.checkIsAlphabetical();
            player.isLetterUsed();
            player.addToUsedLettersArray();
            player.updateBlanks();
            System.out.println("");
            player.setNewBlanks();
        }
        
        String response;
        
        if(player.getLives()==0){ //When player gets 8 letters wrong (loses)
            player.noMoreLives(); //prints "You lost all your lives!"
            System.out.println("Unfortunately, you lose."); //run if player guesses incorrectly 8 times.
            System.out.println("Play again? (Y/N)");
            Scanner myResponse=new Scanner(System.in);
            response=myResponse.next();//Y (yes) or N (no) response
            response=response.toUpperCase(); //there is no case sensitivity
            switch(response)
            {
                case "Y": //yes case
                    System.out.println("");
                    System.out.println("---");
                    Hangman.main(args); //refresh game
                    break;
                case "N": //no case
                    System.out.println("Game Over. Thank you for playing.");  
                    break;
                default: //if player does not enter 'Y' or 'N', this executes and runs until player enters a valid choice
                    while((!response.equals("Y")) && (!response.equals("N"))) {
                       System.out.println("Play again? (Y/N)");
                       response=myResponse.next();
                       response=response.toUpperCase(); //there is no case sensitivity
                        switch(response)
                        {
                            case "Y": //yes case
                                System.out.println("");
                                System.out.println("---");
                                Hangman.main(args); //refresh game
                                break;
                            case "N": //no case
                                System.out.println("Game Over. Thank you for playing.");   
                                break;
                        }
                    } 
            }
        }
       
        else if(player.getMaxTries()==0){ //When player completes all letters (player wins)
            System.out.println("Congratulations! You win!"); //run if player gets all the letters right.
            System.out.println("Play again? (Y/N)");
            Scanner myResponse=new Scanner(System.in);
            response=myResponse.next();//Y (yes) or N (no) response
            response=response.toUpperCase(); //there is no case sensitivity
            switch(response)
            {
                case "Y": //yes case
                    System.out.println("");
                    System.out.println("---");
                    Hangman.main(args); //refresh game
                    break;
                case "N": //no case
                    System.out.println("Game Over. Thank you for playing.");  
                    break;
                default: //if player does not enter 'Y' or 'N', this executes and runs until player enters a valid choice
                    while((!response.equals("Y")) && (!response.equals("N"))) {
                       System.out.println("Play again? (Y/N)");
                       response=myResponse.next();
                       response=response.toUpperCase(); //there is no case sensitivity
                        switch(response)
                        {
                            case "Y": //yes case
                                System.out.println("");
                                System.out.println("---");
                                Hangman.main(args); //refresh game
                                break;
                            case "N": //no case
                                System.out.println("Game Over. Thank you for playing.");   
                                break;
                        }
                    } 
            }        
        }
        
       
    }  
}
