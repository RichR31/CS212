/**
  *Bird.java
  *@description A Bird class that inherits the Animal class
  *@author Ricardo Salazar
  *@version 1.0 2022-02-21
*/

public class Bird extends Animal{
  // ---- attributes ----
  private String species;

  // ---- methods ----

  /** constructor */
  public Bird(String name, int age){
    super(name);
    setAge(age);
    setAnimal();
  }

  public void setAnimal(){
    animal = "bird";
  }

  public void setSpecies(String species){
    this.species = species;
  }
  public String setSpecies(){
    return species;
  }

  public String toString(){
    String s = "The patient is a " + species + ". ";
    s += super.toString();
    return s;
  }

  /** main method*/
  public static void main(String[] args) {
    Bird bird1 = new Bird("Allie", 2);
    bird1.setSpecies("Papagayo");
    System.out.println(bird1);
  }
}
