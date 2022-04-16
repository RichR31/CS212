/**
  * Dog.java
  * @author SJ Zelenberg
  * @description Example using interface Animal class
  * @version 1.0 2022-01-31
*/

public class Dog implements Animal{

  private double weight;

  /** constructor */
  public Dog(){
    weight = 80.0;
  }

  /** sound method */
  public String sound(){
    return "Bark!";
  }

  /** returns the species */
  public String species(){
    return "dog";
  }

  /** calculates weight */
  public int legs(){
    return 4;
  }

  /** calculates weight */
  public double getWeight(Boolean withfur){
    if (withfur){
      return weight;
    }else{
      return weight-1.5;
    }
  }

  public String toString(){
    String s = "This " + species() + " has " + legs() + " legs";
    return s;
  }

  /** main method */
  public static void main(String[] args) {
    Dog buster = new Dog();
    System.out.println(buster);
  }

}
