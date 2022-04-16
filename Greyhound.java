/**
  * GreyHound.java
  * @author Ricardo Salazar
  * @description A child class of the Animal Class
  * @version 3.0 2022-02-19
*/

public class Greyhound extends Dog{
  // --- attributes ---
  private int yearsRacing;

  // --- methods ---

  /** constructor method */
  public Greyhound(String name){
    super(name);
    super.setBreed("greyhound");

  }

  public void setHistoryOfRacing(int y){
    yearsRacing = y;
  }

  public int getHistoryOfRacing(){
    return yearsRacing;
  }

  public String toString(){
    String s = super.toString();
    s+= " They are have been racing for " + yearsRacing + " years.";
    return s;
  }

  //public void setBreed(){}
  /** main methods */
  public static void main(String[] args) {
    Greyhound test = new Greyhound("Spock");
    test.setAge(3);
    System.out.println(test);
  }

}
