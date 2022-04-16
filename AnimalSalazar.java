/**
  *AnimalSalazar.java
  *@description A class for an animal shelter
  *@authorn Ricardo Salazar
  *@version 3.0 2022-02-18
*/
public class AnimalSalazar{

  // --- attributes ---

  private final String ANIMAL;
  private final String NAME;
  private int age;
  private double weight;
  private String specialNotes = "Nothing written";
  private static int numberOfAnimals = 0;
  public final int ID_NUMBER;

  // --- methods ---

  /** constructor*/
  public AnimalSalazar(String name, int animal){
    if (animal == 1){
      ANIMAL = "dog";
    } else if (animal == 2){
      ANIMAL = "cat";
    } else if (animal == 3){
      ANIMAL = "rabbit";
    } else{
      ANIMAL = "other";
    }

    NAME = name;
    ID_NUMBER = 500 + numberOfAnimals;
    numberOfAnimals++;
  }

  /** Getter for the attribute ANIMAL*/
  public String getAnimal(){
    return ANIMAL;
  }

  /** Getter for the attribute NAME*/
  public String getName(){
    return NAME;
  }

  /** Getter for the attribute age*/
  public int getAge(){
    return age;
  }

  /** Getter for the attribute weight*/
  public double getWeight(){
    return weight;
  }

  /** Getter for the attribute specialNotes*/
  public String getSpecialNotes(){
    return specialNotes;
  }

  /** Getter for the attribute ID_NUMBER*/
  public int getIdNumber(){
    return ID_NUMBER ;
  }

  /** Setter for the attribute age*/
  public void setAge(int age){
    this.age = age;
  }

  /** Setter for the attribute weight*/
  public void setWeight(double weight){
    this.weight = weight;
  }

  /** Setter for the attribute specialNotes*/
  public void setSpecialNotes(String specialNotes){
    this.specialNotes = specialNotes;
  }


  /** returns a full description of the shelter animal as a sentence*/
  public String toString(){
    String s = "Type of animal: " + ANIMAL;
    s += ", ID number: " + ID_NUMBER;
    s +=  ". Their name is " + NAME;
    s += ", they are " + age + " years old";
    s += ", and their weight is " + (weight * 16) + " oz.";
    s += " Special notes: " + specialNotes + ".";
    return s;
  }

  /** main method*/
  public static void main(String[] args) {
    AnimalSalazar animal1 = new AnimalSalazar("Ruperto", 2);
    AnimalSalazar animal2 = new AnimalSalazar("America", 1);
    AnimalSalazar animal3 = new AnimalSalazar("Bobby", 3);
    AnimalSalazar animal4 = new AnimalSalazar("Lola", 4);
    AnimalSalazar animal5 = new AnimalSalazar("Rita", 2);

    animal1.setAge(2);
    animal1.setWeight(10);
    animal1.setSpecialNotes("Alergic to oxygen");

    animal2.setAge(6);
    animal2.setWeight(7.4);

    animal3.setAge(5);
    animal3.setWeight(12);
    animal3.setSpecialNotes("Needs his toy for sleeping");

    animal4.setAge(3);
    animal4.setWeight(7.8);

    animal5.setAge(9);
    animal5.setWeight(5.1);

    System.out.println(animal1);
    System.out.println(animal2);
    System.out.println(animal3);
    System.out.println(animal4);
    System.out.println(animal5);
  }


}//end of class
