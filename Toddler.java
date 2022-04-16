/**
  *Toddler.java
  *@description A class for managing data on toddlers
  *@author Ricardo Salazar
  *@version 1.0 2022-01-21
*/

public class Toddler{

  // ----attributes----
  private String firstName;
  private String lastName;
  private String birthday;
  private double height;
  private double weight;

  // ----methods----


  /** Constructor of class */
  public Toddler(String fn, String ln){
    firstName = fn;
    lastName = ln;
    birthday = "January 1st";
    height = 1.0;
    weight = 20.0;
  }

  /** resets height*/
  public void setHeight(double newHeight){
    height = newHeight;
  }
  /** resets weight*/
  public void setWeight(double newWeight){
    weight = newWeight;
  }

  /** resets birthday*/
  public void setBirthday(String newBirthday){
    birthday = newBirthday;
  }

  /** prints informations of the object */
  public String toString(){
    String s;
    s = "This toddler, " + firstName + " " + lastName;
    s += " was born on " + birthday + " and is " + height + " feet, ";
    s += "and " + weight + " pounds.";

    return s;

  }
  /** main class */
  public static void main(String[] args) {
    Toddler annie;
    annie = new Toddler("Annie", "Salazar");
    annie.setHeight(1.9);
    annie.setWeight(27);
    annie.setBirthday("July 20th");
    System.out.println(annie.toString());
  }

}
/**
A constructor that takes in information on the author and title as parameters.
A method that returns the author attribute *
A method that returns the title attribute *
A method that sets the publisher attribute *
A method that returns the publisher attribute *
A method that sets the year attribute *
A method that returns the year attribute *
A method that sets the pages attribute *
A method that returns the pages attribute *
A method that sets the price attribute *
A method that returns the price attribute *
A toString() method that returns all the attribute information within a string that is a complete sentence. *
A main method where
You create two book objects.*
Both objects have all their attributes set (either through the constructor or through the setter methods.*
You print the string returned by the toString() method.*
All work is expected to be your own. Any outside sources, including people and websites, should be clearly cited within a comment. Full names and/or URLs should be provided as well as what was learned.

Include a header comment as well as documentation comments for each method.
*/
