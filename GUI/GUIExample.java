/**
  *GUIExample.java
  *@description Example of GUI design
  *@author Ricardo Salazar
  *@version 2.0 18-03-2022
*/

import java.awt.*;
import javax.swing.*;

public class GUIExample{
  public static void main(String[] args) {
    JFrame frame = new JFrame("Bi Flag");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(1280, 720);//w and h
    //frame.setResizable(true);//can't be resized

    //frame.setLayout(new BorderLayout());

    /** first Jframe */
    JPanel bg = new JPanel();
    bg.setBackground(Color.WHITE);
    bg.setPreferredSize(new Dimension(1200, 7000));

    JPanel c1 = new JPanel();
    c1.setBackground(new Color(216,9,126));
    c1.setPreferredSize(new Dimension(1200,275));

    JPanel c2 = new JPanel();
    c2.setBackground(new Color(140,87,156));
    c2.setPreferredSize(new Dimension(1200,150));

    JPanel c3 = new JPanel();
    c3.setBackground(new Color(36,70,142));
    c3.setPreferredSize(new Dimension(1200,275));

    //https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

    /**  Second Jframe */
    JFrame ukraineFlag = new JFrame("Ukraine Flag");
    ukraineFlag.setBackground(Color.WHITE);
    ukraineFlag.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ukraineFlag.setSize(1200, 720);
    ukraineFlag.setLayout(new GridLayout(2,1));
    frame.setResizable(false);

    JPanel yellowStripe = new JPanel();
    yellowStripe.setBackground(Color.YELLOW);

    JPanel blueStripe = new JPanel();
    blueStripe.setBackground(Color.BLUE);

    ukraineFlag.add(blueStripe);
    ukraineFlag.add(yellowStripe);


    frame.add(bg);
    bg.add(c1);
    bg.add(c2);
    bg.add(c3);


    ukraineFlag.setVisible(true);
    frame.setVisible(true);//Now you can see it


  }




}
