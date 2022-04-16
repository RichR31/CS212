/**
  *Dog.java
  *@description A Dog class that inherits the Animal class
  *@author Ricardo Salazar
  *@version 1.0 2022-02-18
*/
//Dog is the child class and Animal is the parent
public class Dog extends Animal{
  // ---attribute---
  private String breed;

  // --- methods ---
  public Dog(String name){
    super(name);
    this.setAnimal();
  }

  public void setBreed(String breed){
    this.breed = breed;
  }

  public void setAnimal(){
    animal = "dog";
  }

  public String getBreed(){
    return breed;
  }

  public static void main(String[] args) {
    Dog doggy = new Dog("Wrigley");
    System.out.println(doggy.getAnimal());
    doggy.setAge(3);
    doggy.setWeight(4.3);
    doggy.setBreed("Maltese");
    System.out.println(doggy);

    Dog doggy2 = new Dog("Wrigley");
    System.out.println(doggy2.getAnimal());
    doggy2.setAge(3);
    doggy2.setWeight(4.3);
    doggy2.setBreed("Greater");
    System.out.println(doggy2);
  }
}
