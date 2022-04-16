/**
  *Cat.java
  *@author Ricardo Salazar
  *@description A class that inherits the Animal interface
  *@version 1.0 2022-02-25
  */

  public class Cat implements Animal{
    // --- attributes ---
    private double weight;
    private String name;

    // --- methods ---

    /** constructor */
    public Cat(String name, double weight){
      this.name = name;
      this.weight = weight;
    }

    /** returns the sound */
    public String sound(){
      return "Meow";
    }

    /** returns teh species*/
    public String species(){
      return "cat";
    }

    /** returns number of legs */
    public int legs(){
      return 4;
    }

    /** claculates the weight */
    public double weight(Boolean withfur){
      if(withfur){
        return weight;
      }else{
        return weight - 1;
      }
    }
    /** returns all the information of a cat object to a string*/
    public String toString(){
      String s = "This " + species() + "\'s name is " + name;
      s += ". As expected of a cat, " + name + " has " + legs() + " legs.";
      return s;
    }

    /** main method */
    public static void main(String[] args) {
      Cat c1 = new Cat("Alejandro", 10.2);
      System.out.println(c1);
      System.out.println("They weight " + c1.weight(false) + " lbs.");

    }


  }
