/**
  *ClothingParent.java
  *@description A parent class that implements the Clothing interface
  *@author Ricardo Salazar
  *@version 1.0 02-03-2022
*/
import java.awt.Color;

public abstract class ClothingParent implements Clothing{

  //attributes
  //protected final int SKU;
  protected final String TYPE;
  protected Color mainColor;//should we use a diff reff type?
  protected int percentages[];
  protected double price;
  protected String department, size, materials[];
  // --- methods ---

  /** constructor for class*/
  public ClothingParent(String type){
    TYPE = type;
    //set SKU and main color
  }
  //research how an SKU works for clothing
  //public abstract void setSKU();

  public void setColor(int r, int g, int b){
    mainColor = new Color(r,g,b);
  }


  /** getter for the color */
  public Color getMainColor(){
    return mainColor;
  } //reference type in Java!

  /** getter for the clothing type */
  public String type(){
    return TYPE;
  }

  /** constructor */
  public double getPrice(){
    return price;
  } // Is there a currency type we could use?

  /** constructor */
  /*public long getSKU(){
    return SKU;
  }*/

  /** getter of materials */
  public String getMaterials(){
    String s = "";
    for(int i =0; i<materials.length; i++){
      s += percentages[i] + "% " + materials[i] + "\n";
    }
    return s;
  }

  /** get size method*/
  public String getSize(){
    return size;
  }

  /**  */
  public String getDept(){
    return department;
  }

}
