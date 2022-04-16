/**
  * animal.java
  * @description animal objects for hypothetical vet
  * @author SJ Zelenberg
  * @version 3.0 2022-02-18
*/


public abstract class Animal{

  // ---- attributes ----
  protected String animal;//defined in child class
  protected final String NAME;
  protected final int ID_NUMBER;
  protected static int numOfanimals;
  protected int age;
  protected double weight;
  protected String specialNotes = "Nothing written";

  // ---- methods ----


  /** Constructor of class */
  public Animal(String name){
    // toLowerCase() method for strings converts to lower case letters
    //ref: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html

    NAME = name;
    numOfanimals++;
    ID_NUMBER = 1000000 + numOfanimals;
  }
  public abstract void setAnimal();//

  /** returns animal attribute */
  public String getAnimal(){
    return animal;
  }

  /** returns name attribute */
  public String getName(){
    return NAME;
  }

  /** returns id number attribute */
  public int getIdNumber(){
    return ID_NUMBER;
  }

  /** returns age attributes */
  public int getAge(){
    return age;
  }

  /** returns weight */
  public double getWeight(){
    return weight;
  }

  /** returns specialNotes */
  public String getSpecialNotes(){
    return specialNotes;
  }

  /** sets age attribute */
  public void setAge(int age){
    this.age = age;
  }

  /** sets weight */
  public void setWeight(double weight){
    this.weight = weight;
  }

  /** sets specialNotes */
  public void setSpecialNotes(String specialNotes){

    if (this.specialNotes.equals("Nothing written")){
      this.specialNotes = specialNotes;
    } else if (specialNotes.equals("")){
      System.out.println("No note received; notes unchanged.");
    }else {
      this.specialNotes += "\n" + specialNotes;
    }

  }

  /** prints information of the object */
  public String toString(){
    String s;
    s = "This " + animal + " is named " + NAME + " and is ";
    if (age == 1){
      s+= "a " + age + " year old. ";
    } else {
      s+= age + " years old. ";
    }
    s += NAME + " weighs " + weight + " pounds. " + "Their ID number is " + ID_NUMBER + ". ";
    s += "Extra notes: " + specialNotes + ".\n";
    return s;
  }

  // /** main method for testing */
  // public static void main(String[] args) {
  //
  //   animal lulu = new animal("cat", "Lulu");
  //   lulu.setAge(10);
  //   lulu.setWeight(8);
  //   System.out.println(lulu);
  //
  //   animal ziggy = new animal("cat", "Ziggy");
  //   ziggy.setAge(8);
  //   ziggy.setWeight(8.5);
  //   ziggy.setSpecialNotes("Possibly hit by a car 4 years ago.");
  //   ziggy.setSpecialNotes("X-ray shows massive trauma. Very friendly.");
  //   System.out.println(ziggy);
  //
  //   animal jennifer = new animal("rabbit", "Jennifer");
  //   jennifer.setAge(1);
  //   jennifer.setWeight(2);
  //   jennifer.setSpecialNotes("Jennifer is a male rabbit.");
  //   System.out.println(jennifer);
  //
  //   animal pepita = new animal("bird", "Pepita");
  //   pepita.setAge(12);
  //   pepita.setWeight(0.5);
  //   pepita.setSpecialNotes("Wings need to be trimmed");
  //   System.out.println(pepita);
  //
  // }

}
