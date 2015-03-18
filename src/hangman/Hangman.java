//Susan Wang
//2-4
package hangman;
import java.io.*;

public class Hangman {

    public static void main(String[] args) throws IOException {
        HangmanClass player = new HangmanClass("","","");
        player.setTries(8); //max amount of failed attempts allowed is 8
        player.initializeUsedLetters(); //initializes "" to array by default
        player.findWord(); //generates random word
        player.setBlanks(); //sets the "_" needed
        player.userGuess(); //lets user guess
        player.checkIsAlphabetical(); //checks if user input is alphabetical
        player.isLetterUsed(); //check if letter that user inputs has already been used
        player.addToUsedLettersArray(); //if it is a vaild letter, the letter is stored into an array
        player.updateBlanks(); //updates the "_" if user guesses right
        System.out.println("");
        player.setNewBlanks(); //displays the updated "_"
        while(player.getTries()>0 && player.getMaxTries()>0) { //repeats while user has chances to guess and have not got all the letters
            player.userGuess();
            player.checkIsAlphabetical();
            player.isLetterUsed();
            player.addToUsedLettersArray();
            player.updateBlanks();
            System.out.println("");
            player.setNewBlanks();
        }
        if(player.getTries()==0){
            player.noMoreLives();
            System.out.println("You lose. :-("); //run if player guesses incorrectly 8 times.
        }
        else if(player.getMaxTries()==0){
            System.out.println("You win! :-)"); //run if player gets all the letters right.
        }
        
        
        /*Scanner myFile = new Scanner(new File("src\\hangman\\wordBank.txt"));
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        
        int index=-1;
        String text[]=new String[5000];
        
        while(myFile.hasNext()) 
        {
            index = index + 1;
            text[index] = myFile.nextLine();
        }
        myFile.close();

        String myWord=(text[random.nextInt(index)]); //generates random index number to print out something from a random part of the array
        System.out.println(myWord); //used to test program
        
        String blanks="";
        String letter[]=new String[1000]; //letter array
        int guesses=8; //max number of times players can guess
        
        int i = 0;
        for(i=0;i<myWord.length();i++) { //establishes an array for each blank
            letter[i]= "_ ";
            blanks=blanks+letter[i];
        }
        
        System.out.println(blanks);
        System.out.println();
        
        System.out.println("You have " + guesses + " tries.");
        System.out.print("What is your guess? ");
        String guess = input.next(); //lets user guess
        
        String usedLetters[]=new String[26];
        int usedLetterIndex=0;
        
        boolean letterIsAlreadyUsed=false; //checks if user has input letter that has already been used
        for(usedLetterIndex=0;usedLetterIndex<26;usedLetterIndex++) {
            if(guess==usedLetters[usedLetterIndex]) {
                letterIsAlreadyUsed = true;
            }
        }
        
        if (guess.length()==1 && letterIsAlreadyUsed==false) {
            guess=usedLetters[usedLetterIndex]; //adds the guess to the list of used letters
            usedLetterIndex=usedLetterIndex + 1; //adds new index to store next used letter
            
            if (myWord.contains(guess)) { //checks if letter is guessed right
                System.out.println("True");
                for(i=0;i<myWord.length();i++) {
                    if(myWord.substring(i,i+1).equals(guess)){ 
                        blanks=""; //restarts the blanks
                        guess=guess + " ";
                        letter[i]=guess;
                    }
                    blanks=blanks+letter[i]; //adds letter to blanks
                }
                System.out.println(blanks);
                System.out.println("You have " + guesses + " tries.");
            }
            else {
                guesses=guesses-1;
            }
                    
        }*/

        //for(int j=0;j<=index;j=j+1) {
            //System.out.println(text[j]);
        //}
       
    }  
}
