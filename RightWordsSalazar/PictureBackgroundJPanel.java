/**
  *PictureBackgroundJPanel.java
  *@description A class inheriting the JPanel class to add an image as the background
  *@author Ricardo Salazar
  *@version 1.0 2022-03-23
*/
import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

// child class of JPanel!
public class PictureBackgroundJPanel extends JPanel { // this class defines a panel
  // --- attribute ---
  private ImageIcon image;
  private JLabel label;
  private int imageWidth, imageHeight;
  private double widthScale, heightScale;
  private Graphics2D graphic;

  // --- methods ---
  public PictureBackgroundJPanel(String imgName){
    image = new ImageIcon(imgName);
  }//end of constructor

  /** method that defines resizing and will enbed it in the panel */
  public void paintComponent(Graphics g) {

      //get width and height of image
      imageWidth = image.getIconWidth();
      imageHeight = image.getIconHeight();


      //if it is resized to nothing
      if (imageWidth == 0 || imageHeight == 0){
          return;
      }

      // ratio of panel to image
      widthScale = (double) getWidth() / (double) imageWidth;
      heightScale = (double) getHeight() / (double) imageHeight;

      //create image, embed into panel and size accordingly
      graphic = (Graphics2D) g.create();
      graphic.drawImage(image.getImage(),
              AffineTransform.getScaleInstance(widthScale, heightScale), this);
      graphic.dispose();
  }
}
