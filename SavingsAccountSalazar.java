/**
  * SavingsAccountSalazar.java
  * @author Ricardo Salazar
  * @description A child class of the Account class
  * @version 3.0 2022-02-19
*/

public class SavingsAccountSalazar extends AccountSalazar{
  // --- attributes ---
  private double interest;
  private double minimumBalance = 20.00;
  private double maximumDeposit = 1000000000.00;


  // --- methods ---
  /** constructor */
  public SavingsAccountSalazar(String name, double balance){
    super(name, balance);
  }

  /** method that will display restrictions*/
  public String displayRestrictions(){
    String s = "Currently, there are two restrictions to your account: \n";
    s = "The minimum balance allowed for you account is $" + minimumBalance + " make sure to avoid overdrawing. \n";
    s += "And the maximum sum of money per deposit is $" + maximumDeposit + " please avoid depositing larger sums of funds";
    return s;
  }

  /** method that withdraws from balance and returns amount deducted */
  public double withdrawal(double amount){
    if (amount > balance){
      System.out.println("Cannot withdraw more than " + balance);
      return 0.0;
    }
    balance -= amount;
    return amount;
  }

  /** method that adds a deposit to balance */
  public void deposit(double amount){
    balance += amount;
    System.out.println("Current balance is " + balance);
  }

  /** setter method for interest */
  public void setInterest(double interest){
    this.interest = interest;
  }

  /** getter method for interest */
  public double getInterest(){
    return interest;
  }

  /** methods that adds the interest to the balance */
  public double accruelInterest(){
    double accruelInterest = balance + (balance * interest);
    return accruelInterest;
  }

  public static void main(String[] args) {
    SavingsAccountSalazar account1 = new SavingsAccountSalazar("Ricardo Salazar", 800.30);
    account1.deposit(120);
    account1.setInterest(0.01);
    double lastW = account1.withdrawal(200);

    System.out.println(lastW);

    System.out.println(account1.balance);
    System.out.println(account1.getInterest());
    System.out.println(account1.accruelInterest());
    System.out.println(account1.displayRestrictions());
  }


}
