// Adam vanWestrienen - CS212 - Project #2 "Hangman"

import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Hang { 
  
  private Random wordSelector = new Random();
  private int numGuesses;

  public Hang() {
   this.numGuesses = 7;
  }


  public int getNumGuesses() {
    return numGuesses;
  }

  public void setNumGuesses(int guesses) {
    this.numGuesses = guesses;
  }

  // print function for convenience 
  public static void print(Object o) {
    System.out.println(o);
  }
  
  // Select a random word from the wordBank. 
  public String getRandomWord(ArrayList<String> list) {
	    int index = wordSelector.nextInt(list.size());
	    return list.get(index);
	}
  
  // Create Dashed words ("---") of equal length to the randomly selected words 
  public String dashWords(String word) {
	  String dash = "";
	  for (int i = 0; i < word.length(); i++) {
		 dash += "–"; 
	  }
	  System.out.println(dash);
	  return dash;  
  }
  
  // Did the user get a match
  public static boolean isDirectHit(String word, char guess) {
	    return word.indexOf(guess) != -1;
  }
  
  // Display letters that match
  public static StringBuilder reveal(String targetWord, String hiddenWord, char guess) {
    StringBuilder revealHits = new StringBuilder(hiddenWord);
    int directHitIndex = targetWord.indexOf(guess);
    while (directHitIndex >= 0) {
      revealHits.setCharAt(directHitIndex, guess);
      directHitIndex = targetWord.indexOf(guess, directHitIndex + 1);
    }
    System.out.println("\n");
    return revealHits;
  }
  
  // Check if any letters are unrevealed
  public static boolean dashesRemaining(String dash) {
	  return dash.indexOf("–") != -1;
  }



   /*
   *  The Main Function
   */
  public static void main(String[] args) {
    Scanner user = new Scanner(System.in);
    
    // possible words
    String[] testWords = new String[] {"pitbull", "shark", "watermelon", "soccer", "painting", "necklace", "beaver", 
    		"potato", "popeye", "italy", "madagascar", "argentina", "cinderella", "umbrella", "bigly", "motherfucker",
    		"queens", "panther", "lasagna"};
    
    // import all words to wordBank
    ArrayList<String> wordBank = new ArrayList<String>();
    for (int i = 0; i < testWords.length; i++) {
      wordBank.add(testWords[i]);
    }
    
    boolean exitGame = false;
    int gameCount = 0;
    Hang newGame = null;
  
    while (!exitGame) {
      
      // Get random word and save it 
      newGame = new Hang();
      String wordToGuess = newGame.getRandomWord(wordBank);
      String saveWord = wordToGuess;
      
      // Start of game (round one), get user input and capture it 
      if (gameCount++ == 0) {
        print("Welcome to HANGMAN!");
        print("INSTRUCTIONS: To win you must reveal the hidden word by guessing characters. You will have 7 guesses, each wrong guess counts as a guess attempt. "
        		+ "Enter a '!' at anytime to get a new word or get to exit.\n");
        print("Here we go! Goodluck! Here is your Hangman puzzle: \n");
        
      } 
      else {
        print("Do you want to play again? [y/n]: ");
        Character yn = new Character(user.next().charAt(0));
        if (Character.toUpperCase(yn) != 'Y') {
          exitGame = true;
          break;
        } 
      }
      
      // Random word to guess
      String hiddenWord = newGame.dashWords(saveWord); 
      
      print("Enter a character to begin: ");
      List<Character> usedLetters = new ArrayList<Character>();
      boolean quit = false;
      
      // Game Logic 
      while(!quit && newGame.numGuesses > 0) {
      	
  	      char guess = user.next().charAt(0);
  	      
  	      // Does the user want to quit?
  	      if ( guess == '!') {
  	        quit = true;
  	        break;
  	      }
  	      
  	      // if user enters already used letter
  	      if ((usedLetters).contains(guess)) { 
  	          print("You've already tried that letter, guess again.");
  	        } 
  	      	// if user enters anything other than a letter
  	        if (!Character.isLetter(guess)) {
  	          print("Please enter a LETTER!");
  	        }
  	        // if there is a match
  	        else if (isDirectHit(saveWord, guess)) {
    	        StringBuilder result = reveal(saveWord, hiddenWord, guess);
    	        hiddenWord = result.toString();
    	        print(result.toString().toUpperCase());
    	        usedLetters.add(guess);
  	       } 
  	        // if user guesses wrong
  	       	else {
  	    	 	  print("Sorry, try again.");
  	    	 	  newGame.numGuesses--;
  	    	 	  print("You have " + newGame.numGuesses + " guesses remaining.");
  	    	 	  usedLetters.add(guess);
  	    	 	  }   
  	    	 	  // if all characters have been revealed: winner
  	    	 	  if (dashesRemaining(hiddenWord) == false) {
  	    		    print("WINNER!");
  	    		    quit = true;
  	    	    }
  	    	 	  // Out of guesses: lose game
  	    		  if (newGame.numGuesses == 0) {
  	    			    print("GAME OVER!");
  	    			    quit = true;
  	    		  } 
 
  	    
      } // end while !quit
     
   } // end while !exitGame
   user.close();
   print("Come back soon. Goodbye! \n");
  } // end of main method
} // end of class









