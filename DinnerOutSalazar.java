/**
  *DinnerOutSalazar.java
  *@description a program that will split a bill into a number of up to 6 people
  *@author Ricardo Salazar
  *@version 1.0 2022-02-05
*/

import java.util.Scanner;


public class DinnerOutSalazar{
  // --- attributes ---
  private int n;
  private String[] person = new String[6];
  private double tax, tip;
  private double amount[]= new double[6];
  private Scanner scan = new Scanner(System.in);

  //--- methods ---

  /** constructor */
  public DinnerOutSalazar(){
    System.out.println("Hello! thanks for trying \"SplitMyBill®\" ");
    System.out.println("Please enter the amount of people (1~6) that will split the bill: ");
    n = scan.nextInt();
    this.checkNumber();


  }

  /** checks if the number of people is between 1 to 6 */
  public void checkNumber(){
    while ((n > 6 ) || (n < 1 )){
      if (n > 6 ){
        System.out.println("I'm sorry but the number you entered is bigger than 6, please enter a valid number (1~6)");
        n = scan.nextInt();
      } else if (n < 1 ){
        System.out.println("I'm sorry but the number you entered is less than 1, please enter a valid number (1~6)");
        n = scan.nextInt();
      }
    }
  }

  /** asks and assigns the names for the people paying */
  public void setNames(){
    scan.nextLine();
    for (int x = 0; x < n; x++){
      System.out.print("Please enter the name of the person "+ (x+1) + ": ");
      person[x] = scan.nextLine();
      }
    }

  /** sets the total amount of money spent */
  public void setAmounts(){
    for (int x = 0; x < n; x++){
      System.out.print("Add the value of an item (in decimals), for " + person[x] + ": ");
      amount[x] = addItems(scan.nextDouble());
      }
  }

  /** adds up items to a total */
  public double addItems(double item){
    double sum = 0;
    double newItem = item;
    while ( newItem != 0){
      sum += newItem;
      System.out.println("Do you want to add a new item? If so please enter the cost (in decimals), otherwise enter 0 to proceed to the next person.");
      newItem = scan.nextDouble();
    }
    return sum;
  }

  /** sets the tax rate*/
  public void setTax(){
    System.out.println("Please enter the tax rate (in decimals)");
    tax = scan.nextDouble();
  }

  /** sets the tip */
  public void setTip(){
    System.out.println("Please enter the tip rate (in decimals)");
    tip = scan.nextDouble();
  }
  /** converts all the information into a string */
  public String toString(){
    System.out.println("============================================================");
    System.out.println("TOTAL");
    System.out.println("============================================================");
    String s = "";
    for (int x=0; x < n; x++){
      s += person[x] + ", your total is: $" + this.roundUp(x) + "\n";
    }
    return s;
  }

  /** Sums and rounds up the total for each person */
  public double roundUp(int x){
    double round = (amount[x] + (amount[x] * tax)+(amount[x] * tip));
    round = round * 100;
    round = Math.round(round);
    round = round/100;
    return round;
  }

  /** main method */
  public static void main(String[] args) {
    DinnerOutSalazar dinner = new DinnerOutSalazar();
    dinner.setNames();
    dinner.setAmounts();
    dinner.setTax();
    dinner.setTip();
    System.out.println(dinner);
  }
}
