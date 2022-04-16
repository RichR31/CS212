/**
  * Calculations.java
  * @description Class for the calculations operations
  * @version 1.0 2022-04-04
  * @author Ricardo Salazar
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculations{
  // --- attributes ---
  private String operation;
  private Integer memory;
  private boolean multipleEquals = false;

  // --- methods ---
  public Calculations(){

  }

  public void operation(String number, String op ){
    memory = Integer.parseInt(number);
    operation = op;
    multipleEquals = false;
  }

  public int getMemory(){
    return memory;
  }

  public String equals(String secondNumber){
    int secondNum = Integer.parseInt(secondNumber);
    int remainder = 0;
    int result =0;
    switch (operation){
      case "+":
        result = memory + secondNum;
        break;
      case "-":
        result = memory - secondNum;
        break;
      case "\u00D7":
        result = memory * secondNum;
        break;
      case "\u00F7":
        remainder = result % secondNum;
        result = memory / secondNum;
        break;
      default:
        break;
    }
    if (! multipleEquals){
      memory = secondNum;
    }
    multipleEquals = true;
    if(remainder == 0){
      return Integer.toString(result);
    }
    else{
      return (result + " R " + remainder);
    }

  }


  public static void main(String[] args) {
    Calculations test = new Calculations();
    test.operation("7", "/");
    System.out.println("First number: " + test.getMemory());
    System.out.println(test.memory + " / 2 = " + test.equals("2"));
  }
}
