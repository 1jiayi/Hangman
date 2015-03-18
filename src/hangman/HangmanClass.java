//Susan Wang
//2-4
package hangman;
import java.util.*;
import java.io.*;

public class HangmanClass{
    private String myWord; //random word
    private String guess; //user guess
    private String blanks; //"_"
    private int i;
    private final String letter[]=new String[1000];  //array of each letter from the chosen word
    private final String usedLetters[]=new String[25]; //letters already used
    private int usedLetterIndex=0;
    private int tries; //number of wrong answers user can guess maximum (player's lives)
    private int maxTries; //maximum amount of tries to finish the game
    boolean letterIsAlreadyUsed=false; //checks if user has input letter that has already been used
    boolean isAlphabet; //boolean which states if the user input is part of the alphabet
    
    public int getMaxTries(){
        return this.maxTries;
    }
    
    public int getTries(){ 
     return this.tries;
    }
    public void setTries(int n){
     this.tries=n;
    }
    public HangmanClass(String w,String g,String b) { //tries is 8
        w = myWord;
        g = guess;
        b = blanks;
    }
    
    
    public void findWord() throws IOException{
        Scanner myFile = new Scanner(new File("src\\hangman\\wordBank.txt"));
        Random random = new Random();
        int index=-1;
        String text[]=new String[5000];
        while(myFile.hasNext()) 
            {
            index = index + 1;
            text[index] = myFile.nextLine();
            }
        myFile.close();
        myWord=(text[random.nextInt(index)]); //generates random index number to print out something from a random part of the array
        myWord=myWord.toLowerCase(); //game not case sensitive to capitalization
        maxTries=myWord.length();
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
        System.out.println("You have " + tries + " lives.");
        System.out.print("Enter a letter: ");
        Scanner input = new Scanner(System.in);
        guess = input.next(); //lets user guess
        guess=guess.toLowerCase(); //game not case sensitive to capitalization
    }
    
    public void noMoreLives(){ //displays if player loses
        System.out.println("You lost all your lives!");
    }
    
   public void initializeUsedLetters() { //default used letters before game starts
    usedLetterIndex=0;
    while(usedLetterIndex<25) {
        usedLetters[usedLetterIndex]="";
        usedLetterIndex=usedLetterIndex+1;
    } 
}
   
   public void addToUsedLettersArray(){ //stores user guess to array of used letters
       usedLetterIndex=0;
       if(letterIsAlreadyUsed==false && guess.length()==1 && isAlphabet==true ){
       while(usedLetterIndex<25) {
           if(!(usedLetters[usedLetterIndex].equals(""))) {
               usedLetterIndex=1+usedLetterIndex;
           }
           else {
               usedLetters[usedLetterIndex]=guess;
               break;
           }
       }
     }
   }
   
    public void isLetterUsed(){ //checks if letter has been used
        letterIsAlreadyUsed=false;
        for(usedLetterIndex=0;usedLetterIndex<25;usedLetterIndex++) {
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
    
    public void updateBlanks(){
        if (guess.length()==1 && letterIsAlreadyUsed==false && isAlphabet==true) {
            if (myWord.contains(guess)) { //checks if letter is guessed right
                //System.out.println(myWord.contains(guess));
                System.out.println("You guessed correctly.");
                i=0;
                while(i<myWord.length()) {
                    if(myWord.substring(i,i+1).equals(guess)) {
                        letter[i]=guess + " ";
                        maxTries=maxTries-1; //maxTries reduces when player guesses right
                    }
                    i=i+1;
                }   

            }
            else {
                System.out.println("You guessed wrong.");
                tries=tries-1;
            }         
        }
    }
    
    
        public void setNewBlanks(){
        blanks="";
        i = 0;
        for(i=0;i<myWord.length();i++) { //creates the blanks with the letter arrays;
            blanks=blanks+letter[i];
        }
        System.out.println(blanks);
    }
    
}