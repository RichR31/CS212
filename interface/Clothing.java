/**
  * Clothing.java
  * @description an interface for clothing-type classes
  * @version 1.0 2022-02-28
  * @author Ricardo Salazar
*/
import java.awt.Color;

public interface Clothing{

  public Color getMainColor(); //reference type in Java!

  public String type();

  public double getPrice(); // Is there a currency type we could use?

  //public long getSKU();

  public String getMaterials();

  public String getSize();

  public String getDept();

}
