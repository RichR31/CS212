/**
  * ScreenTest.java
  * @description a class for GUI development for the game "All the right words"
  * @version 1.0 2022-04-11
  * @author Ricardo Salazar
*/
import javax.swing.*;
import java.awt.*;
public class ScreenTest {
  private JFrame frame;
  //private PictureBackgroundJPanel background;

  //background = new PictureBackgroundJPanel("MiddleBackground.jpg")



  public ScreenTest(){
    frame = new JFrame("This is just a test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(960,540);
    frame.setResizable(false);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    ScreenTest test = new ScreenTest();
  }

}
