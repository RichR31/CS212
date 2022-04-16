/**
  *BankAccount.java
  *@description A class for bank accounts
  *@author Ricardo Salazar
  *@version 1.0 2022-01-24
*/

public class BankAccount{
  // ---attributes ---
  private final String NAME;
  private final int ACCOUNTNUMBER; //this number can't change
  private double balance = 0.0;
  private static int numberOfAccounts = 0;
  private static final int ROUTINGNUMBER=123456467;

  // --- methods ---

  /** constructor */
  public BankAccount(String name, double balance){
    NAME = name;
    this.balance = balance;
    numberOfAccounts++;
    ACCOUNTNUMBER = 100000 + numberOfAccounts;
    System.out.println(this);
  }

  /** method that returns ACCOUNTNUMBER */
  public int getAccountNumber(){
    return ACCOUNTNUMBER;
  }

  /** method that returns balance */
  public double getBalance(){
    return balance;
  }

  /** method that resets balance */
  public void setBalance(double balance){
    this.balance += balance;
  }

  /** method that gets the value of NAME attribute */
  public String getName(){
    return NAME;
  }
  /** static method that gets the value of numberOfAccounts attribute */
  public static int getNumberOfAccounts(){
    return numberOfAccounts;
  }
  /** static method that gets the value of ROUTINGNUMBER attribute */
  public static int getRoutingNumber(){
    return ROUTINGNUMBER;
  }

  public String toString(){
    String s = "This account is owned by " + NAME;
    s += " They have $" + balance + ". Their account number is ";
    s += ACCOUNTNUMBER;
    return s;
  }

  /** main method */
  public static void main(String[] args) {

    BankAccount acc1 = new BankAccount("Ricardo Salazar", 20);
    BankAccount acc2 = new BankAccount("Arturo Cuellar", 344);
    BankAccount acc3 = new BankAccount("Martha Ortiz", 344);
    BankAccount acc4 = new BankAccount("Andrea Zambrano", 344);

    
  }



}// end of class
