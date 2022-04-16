/**
  * Account.java
  * @author Ricardo Salazar
  * @description A basic bank account class
  * @version 3.0 2022-02-19
*/

public abstract class AccountSalazar{

  // ----- attributes ------
  protected final int ACCOUNTNUMBER; // this is a constant
  protected double balance;
  protected static int numberOfAccounts = 0; // class variable
  protected static final int ROUTINGNUMBER = 1234567890; // class constant
  protected final String NAME;


  // ----- methods ------
  /** constructor  */
  public AccountSalazar(String name, double balance){
    NAME = name;
    this.balance = balance;
    ACCOUNTNUMBER = 10000 + numberOfAccounts;
    numberOfAccounts++;
    System.out.println(this);
  }

  /** abstract method that will display restrictions*/
  public abstract String displayRestrictions();

  /** withdraws from balance and returns amount deducted */
  public abstract double withdrawal(double amount);

  /** adds to balance */
  public abstract void deposit(double amount);

  /** returns ACCOUNTNUMBER for the instance */
  public int getAccountNumber(){
    return ACCOUNTNUMBER;
  }

  /** returns balance for the instance */
  public double getBalance(){
    return balance;
  }

  /** getter for the NAME instance attribute*/
  public String getName(){
    return NAME;
  }

  /** static method that returns number of accounts made */
  public static int getNumberOfAccounts(){
    return numberOfAccounts;
  }

  /** static method that returns routing number  */
  public static int getRoutingNumber(){
    return ROUTINGNUMBER;
  }

  /** toString prints content of account */
  public String toString(){
    String s = "This account is owned by " + NAME;
    s += ". They have $" + balance + ". Their account number ";
    s += "is " + ACCOUNTNUMBER;
    return s;

  }


}
