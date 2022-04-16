/**
 * PanelFilledWithPicture.java
 *
 * @version 2 2022-03-23
 * @authorship SJ Zelenberg
 * @description example of panel class with gif/jpeg/jpg/png
*/

import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

// child class of JPanel!
public class PanelFilledWithPicture extends JPanel { // this class defines a panel

  private ImageIcon image;
  private JLabel label;
  private int imageWidth, imageHeight;
  private double widthScale, heightScale;
  private Graphics2D graphic;

  //--------------------------------------------------------------
  // Constructor contains the image that will be the background
  //--------------------------------------------------------------
  public PanelFilledWithPicture(){
    image = new ImageIcon("background2.jpg");
  }//end of constructor

  //--------------------------------------------------------------
  // paintComponent defines resizing and embeds into panel
  //--------------------------------------------------------------
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
  }//end of paint component



}//end of class
