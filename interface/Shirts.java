/**
  * Shirts.java
  * @description a class to make inventory if a dept Store
  * @version 1.0 14-03-2022
  * @author Ricardo S
*/

public class Shirts extends ClothingParent{
  // --- attributes---
  private static int  styles = 0; //DO we need this?
  private int stock;
  private SleeveLength sleeveLength;
  private String itemName ;

  public Shirts(String name, int startingStock){
    super("Shirt");
    styles ++;
    itemName = name;
    stock = startingStock;
  }

  public void setSleeveLength (int sleeveType){
    SleeveLength[] sleeves = SleeveLength.values();
    sleeveLength = sleeves[sleeveType];
  }

  public SleeveLength getSleeveLength(){
    return sleeveLength;
  }


  public static void main(String[] args) {
    Shirts newS = new Shirts("Bilabong tee shirts", 35);
    newS.setSleeveLength(1);
    System.out.println(newS.getSleeveLength());

  }





/** Enum for sleeve length - a nested class!*/
enum SleeveLength{
  SPAGHETTI,
  SLEEVELESS,
  CAP,
  SHORT,
  THREE_QUARTER,
  LONG;
}
}
