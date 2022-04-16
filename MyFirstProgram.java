/**
  *MyFirstProgram.java
  *@description A Simple program to run Java
  *@author Ricardo Salazar
  *@version 1.0 2022-01-14
*/

import java.util.Scanner;

public class MyFirstProgram{

  public static void main(String[] args){

    Scanner input = new Scanner(System.in); //declaration and creation of the object
    System.out.println("Please type your name:");
    String s; //declaration statement
    s = "welcome to Lake Forest, " + input.nextLine() + "!"; //assignment statement
    System.out.println(s);

  }// end of method
}// end of class
