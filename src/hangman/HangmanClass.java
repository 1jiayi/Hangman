//Susan Wang
//2-4
package hangman;
import java.util.*;
import java.io.*;
        
public class HangmanClass{
    private String myWord; //random word
    private String guess; //user guess
    private String blanks; //"_"
    private int i; //test number
    private final String letter[]=new String[1000];  //array of each letter from the chosen word
    private final String usedLetters[]=new String[26]; //letters already used
    private int usedLetterIndex=0; //index of array with used letters
    private int lives; //number of wrong answers user can guess for a maximum amount (player's lives)
    private int maxTries; //maximum amount of tries to finish the game
    boolean letterIsAlreadyUsed; //checks if user has input letter that has already been used
    boolean isAlphabet; //boolean which states if the user input is part of the alphabet
    
    public void setLives(int n){ //sets the player's lives to n
     this.lives=n;
    }
        
    public int getLives(){  //gets the number of player's lives (amount of times that the user can guess wrong)
     return this.lives;
    }
    
    public int getMaxTries(){ //gets the max number of correct tries required to finish the game
        return this.maxTries;
    }

    
    public HangmanClass(String w,String g,String b) { 
        w = myWord;
        g = guess;
        b = blanks;
    }
    
    
    public void findWord() throws IOException{
        Random random; 
        int index;
        String[] text;
        try (Scanner myFile = new Scanner(new File("src\\hangman\\wordBank.txt")) //refers random work to wordBank.txt
        ) { 
            random = new Random();
            index = -1;
            text = new String[5000]; //array of each word from each line in the wordBank.txt document
            while(myFile.hasNext())
            {
                index = index + 1;                    //initializes each word of wordBank.txt as a part of the array
                text[index] = myFile.nextLine();
            }
        }
        myWord=(text[random.nextInt(index)]); //generates random index number to print out something from a random part of the array
        myWord=myWord.toLowerCase(); //game not case sensitive to capitalization
        maxTries=myWord.length(); //max amount of right tries to complete the game
        System.out.println(myWord);
    }
    
    public void setBlanks(){ //run this at start of game
        blanks="";
        i = 0;
        for(i=0;i<myWord.length();i++) { //establishes an array for each blank
            letter[i]= "_ ";
            blanks=blanks+letter[i];
        }
        System.out.println(blanks);
    }
    
    public void userGuess(){
        System.out.println("You have " + lives + " lives."); 
        System.out.print("Enter a letter: ");
        Scanner input = new Scanner(System.in);
        guess = input.next(); //lets user guess
        guess=guess.toLowerCase(); //game not case sensitive to capitalization
    }
    
    public void noMoreLives(){ //displays if player loses
        System.out.println("You have no more lives!");
    }
    
   public void initializeUsedLetters() { //default used letters before game starts
    usedLetterIndex=0;
    while(usedLetterIndex<26) {
        usedLetters[usedLetterIndex]=""; //since this is initialized before the user has the option to guess, all the used letters are set to "" by default
        usedLetterIndex=usedLetterIndex+1;
    } 
}
   
   public void addToUsedLettersArray(){ //stores user guess to array of used letters
       usedLetterIndex=0;
       if(letterIsAlreadyUsed==false && guess.length()==1 && isAlphabet==true ){ //if the letter has not been used, the guess length is 1 and is alphabetical, it's stored to the used letters array
       while(usedLetterIndex<26) {
           if(!(usedLetters[usedLetterIndex].equals(""))) { //skips arrays that are not equal to "" to prevent replacement
               usedLetterIndex=1+usedLetterIndex;
           }
           else {
               usedLetters[usedLetterIndex]=guess; //if the array is not "", the array stores in guess and the while loop ends
               break;
           }
       }
     }
   }
   
    public void isLetterUsed(){ //checks if letter has been used
        letterIsAlreadyUsed=false; //assumes letter is not used until proven
        for(usedLetterIndex=0;(usedLetterIndex<26) && (!usedLetters[usedLetterIndex].equals(""));usedLetterIndex++) { //checks if guess equals any of the used letters array
            if(guess.equals(usedLetters[usedLetterIndex])) {
                letterIsAlreadyUsed = true;
            }
        }
        if(letterIsAlreadyUsed==true){
            System.out.println("You have used that letter already!");
        }
    }
    
    public void checkIsAlphabetical(){ //checks if user input is alphabetical
        isAlphabet=false;
        if(guess.equals("a") || guess.equals("b") || guess.equals("c") || guess.equals("d") || guess.equals("e") || guess.equals("f") || guess.equals("g") || guess.equals("h") || guess.equals("i") || guess.equals("j") || guess.equals("k") || guess.equals("l") || guess.equals("m") || guess.equals("n") || guess.equals("o") || guess.equals("p") || guess.equals("q") || guess.equals("r") || guess.equals("s") || guess.equals("t") || guess.equals("u") || guess.equals("v") || guess.equals("w") || guess.equals("x") || guess.equals("y") || guess.equals("z")) {
            isAlphabet=true;
        }
        else{
            System.out.println("Invalid input. (Must be a single letter from A to Z)");
        }
    }
    
    public void updateBlanks(){ //makes changes in the "_" if user guesses right
        if (guess.length()==1 && letterIsAlreadyUsed==false && isAlphabet==true) { //RIGHT ANSWER CASE
            if (myWord.contains(guess)) { //checks if letter is guessed right
                //System.out.println(myWord.contains(guess));
                System.out.println("You guessed correctly.");
                i=0;
                while(i<myWord.length()) { //each letter contained in myWord is checked to see if it equals the user input
                    if(myWord.substring(i,i+1).equals(guess)) {
                        letter[i]=guess + " "; //if the user guesses right, part of the array for the "_" gets replaced with the correct guess
                        maxTries=maxTries-1; //maxTries reduces when player guesses right
                    }
                    i=i+1;
                }   

            }
            else { //WRONG ANSWER CASE
                System.out.println("You guessed wrong.");
                lives=lives-1; //number of allowed wrong guesses decrease (life lost)
            }         
        }
    }
    
    
        public void setNewBlanks(){ //displays the updated "_" with some of the "_" replaced with the right letters if the user guesses right
        blanks=""; //restarts blanks
        i = 0;
        for(i=0;i<myWord.length();i++) { //creates the blanks with the letter arrays;
            blanks=blanks+letter[i]; //adds the "_" and correct guessed letters up
        }
        System.out.println(blanks); //displays updated "_"'s
    }
    
       
 }
