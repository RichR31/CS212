/**
  *PassToArgs.java
  *@description A program that accepts inputs from the terminal
  *@author Ricardo Salazar
  *@version 1.0 2022-02-14
*/

public class PassToArgs{

  /** Prints strings provided in terminal */
  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++){
      System.out.println(i + " " +args[i]); //print args
    }
  }
}
