/**
  *TerminalCalculatorProgram.java
  *@description A Simple program to run Java
  *@author Ricardo Salazar
  *@version 1.0 2022-01-14
*/

import java.util.Scanner;

public class TerminalCalculatorProgram{

  public static void main(String[] args){

    Scanner input = new Scanner(System.in); //Creation of a new intance object of Scanner
    final double PI = 3.14;

    //take in first number
    System.out.println("Type an integer, please");//
    int numb1 = input.nextInt();

    //take in operation
    System.out.println("Type an operation (+, -, *, / or \"pi times\")");
    input.nextLine();
    String operation = input.nextLine();

    //take in second number
    System.out.println("Type another number");
    int numb2 = input.nextInt();

    double result = 0;
    //If statement
    if(operation.equals("+")){
      result = numb1 + numb2;
    } else if(operation.equals("*")){
      result = numb1 * numb2;
    }else if (operation.equals("pi times")){
      result = numb1*numb2* PI;
    }
    else{
      System.out.println("I don't kow how to do that");
    }
    System.out.println(result);

  }// end of method
}// end of class
