/**
  *Coinstar.java
  *@descriptions takes in coins, calculates value and returns cash.
  *@author Ricardo Salazar
  @version 1.0 2022-02-04
*/
import java.util.Scanner;
public class Coinstar{
  // --- attributes ---
  private int total current;
  private Scanner scan = new Scanner(System.in);

  // --- methods ---
  public Coinstar(){}

  /** takes in coins from user */
  public void intake(){
    //pennies
    System.out.print("Enter the number of pennies: ");
    pennies = scan.nextInt();
    //nickels
    System.out.print("Enter the number of nickels: ");
    nickels = scan.nextInt();
    //dimes
    System.out.print("Enter the number of dimes: ");
    dimes = scan.nextInt();
    //quarters
    System.out.print("Enter the number of quarters: ");
    quarters = scan.nextInt();
    //halfDollars
    System.out.print("Enter the number of half Dollars: ");
    halfDollars = scan.nextInt();
    //one dollar coins
    System.out.print("Enter the number of one dollar coins: ");
    ones = scan.nextInt();
  }

  public static void main(String[] args) {
    Coinstar counter = new Coinstar();
    counter.intake();
  }
}
