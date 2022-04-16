/**
  *Coinstar.java
  *@descriptions takes in coins, calculates value and returns cash.
  *@author Ricardo Salazar
  @version 1.0 2022-02-04
*/
import java.util.Scanner;
public class Coinstar{
  // --- attributes ---
  private int coins[] = new int[6], fives, tens, twenties, fifties, hundreds;
  private Scanner scan = new Scanner(System.in);
  private String[] currency = new String[]{"pennies", "nickels", "dimes", "quarters", "half dollars", "One dollar coins"};
  private int pennyValues[] = new int[]{1,5,10,25,50,100,500,1000,2000,5000,10000};

  // --- methods ---
  public Coinstar(){}

  /** takes in coins from user */
  public void intake(){
    for(int x = 0; x < 6; x++){
      System.out.print("Enter the number of " + currency[x] + ": ");
      coins[x] = scan.nextInt();
    }
  }

  /** calculates and prints total value */
  public int totalValue(){
    int money=0;
    for(int x = 0; x<6; x++){
      money += coins[x] * pennyValues[x];
    }
    System.out.println("You have $" + (money/100) + ((money%100) * 0.01));
    return money;
  }
  /** calculates the change */
  public void makeChange(int money){
    double amount;
    //prints the amount of bills
    for (int x= (pennyValues.length-1); x >= 5; x--){
      if (money >= pennyValues[x]) {
        amount = money/pennyValues[x];
        money %= pennyValues[x];
        System.out.println("You have " + ((int)amount) +" $" + (pennyValues[x]/100) + "  bill(s)");
      }
    }
    //prints the amount of coins
    for (int x= (currency.length-2); x >= 0; x--){
      if (money >= pennyValues[x]) {
        amount = money/pennyValues[x];
        money %= pennyValues[x];
        System.out.println("You have " + ((int)amount) +" " + (currency[x]));
      }
    }
  }



  public static void main(String[] args) {
    Coinstar counter = new Coinstar();
    counter.intake();
    counter.makeChange(counter.totalValue());

    //example of rounding
    /*double money;
    money = 234.6;
    System.out.println(money);
    money = money / 10;
    long newMoney =  Math.round(money);
    System.out.println(money);
    System.out.println(newMoney * 10);*/

  }
}
