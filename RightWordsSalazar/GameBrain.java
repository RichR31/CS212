/**
  * GameBrain.java
  * @description class that manages the selection of words and calculation of points
  * @version 2.0 2022-04-19
  * @author Ricardo Salazar
*/

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GameBrain{
  // --- attributes ---
  private int score = 0;
  private String bag[] = {"A","A","A","A","A","A","A","A","A","B","B","C","C",
  "D","D","D","D","E","E","E","E","E","E","E","E","E","E","E","E","F","F","G",
  "G","G","H","H","I","I","I","I","I","I","I","I","I","J","K","L","L","L","L",
  "M","M","N","N","N","N","N","N","O","O","O","O","O","O","O","O","P","P","Q",
  "R","R","R","R","R","R","S","S","S","S","T","T","T","T","T","T","U","U","U",
  "U","V","V","W","W","X","Y","Y","Z"};

  private Random rand = new Random();
  private ArrayList<String> letters;
  private ArrayList<Character> characters;

  /** constructor */
  public GameBrain(){}

  // --- methods ---
  public String[] getLetters(){
    letters = new ArrayList<String>();
    ArrayList<Integer> numbers =new ArrayList<Integer>();
    int number;

    while(letters.size() < 7){

      number = rand.nextInt(bag.length);

      if (!numbers.contains(number)){
        numbers.add(number);
        letters.add(bag[number]);
      }
    }
    return letters.toArray(new String[letters.size()]);
  }
  // determines if the word sumbmited is a valid word
  public Boolean isValid(String word){
    Boolean valid = false;
    try{
      File validWords = new File("valid_words.txt");
      Scanner scanFile = new Scanner(validWords);

      while(scanFile.hasNextLine()){
        String fileLine = scanFile.nextLine();

        if(word.equals(fileLine)){
          valid = true;
        }
      }
      scanFile.close();
    } catch (FileNotFoundException exception){
      System.out.println("EROR OCURRED: ");
      exception.printStackTrace();
    }

    return valid;
  }
  // determines if the word submited was inserted from the letter bank options
  public Boolean isFromLetterBank(String word, String[] letterArray){
    ArrayList<String> letterList = new ArrayList<String>(Arrays.asList(letterArray));
    Boolean valid = true;

    for ( int i = 0; i < word.length(); i++){
      char letter = word.charAt(i);
      if (letterList.contains(String.valueOf(letter))){
        int index = letterList.indexOf(String.valueOf(letter));
        letterList.remove(index);
      } else{
        valid = false;
      }
    }

    return valid;
  }


  // determines the score of a string
  public int scoreOf(String word){
    int points = 0;

    for ( int i = 0; i < word.length(); i++){
      char letter = word.charAt(i);

      switch (letter){
        case 'D': case 'G':
          points += 2;
          break;
        case 'B': case 'C': case 'M': case 'P':
          points += 3;
          break;
        case 'F': case 'H': case 'V': case 'W': case 'Y':
          points += 4;
          break;
        case 'K':
          points += 5;
          break;
        case 'J': case 'X':
          points += 8;
          break;
        case 'Q': case 'Z':
          points += 10;
          break;
        default:
          points += 1;
          break;
      }
    }
    return points;
  }
}
