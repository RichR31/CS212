/**
  * MiddleCampus.java
  * @description The Middle Campus GUI
  * @author Malek ELaghel, William Hernandez, Amaan Syed, Yasar Sadozai, Jessica Li // enter your names here
  * @version 2.0 04-15-2022
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;

public class MiddleCampus { // extends JPanel { ?

  // ----- attributes -----
  private JFrame frame;
  private PictureBackgroundJPanel background;
  private JPanel scorePanel, headerPanel;
  /*private JButton lillard, brown, hotchkiss, lib, carnegie, facman, north,
                  patterson, ravine, reid, lilychapel, blackstone, harlan, mohr,
                  backToMain, easterEgg1, easterEgg2; //JLabels? -M*/
  private Font  headerFont, scoreFont, cursorFont, scoreNumFont;
  private JLabel headerLabel, scoreLabel, scoreNumLabel;//, imageLabel, imageLabel2;
  private Color red;
  private String buildingNames[] = {"Patterson Lodge", "Ravine Faculty Art Studios", "North Hall", "Facilities Management",
                            "Lillard Science Center", "Carnegie Hall", "Brown Hall", "Hotchkiss Hall",
                            "Donnelley and Lee Library", "Mohr Student Center", "The Cafereria", "Calvin Durand Hall",
                            "Harlan Hall", "Blackstone Hall", "Lily Reid Holt Memorial Chapel"};
  private JButton buildings[] = new JButton[15];
  private int widths[] = new int[]{28,25,62,66,159,53,110,68,132,79,76,79,146,84,93};
  private int heights[] = new int[]{41,22,46,45,84,39,79,48,90,83,71,74,117,133,110};
  private int xPixels[] = new int[]{130,175,243,334,426,587,319,637,530,575,473,450,279,193,164};
  private int yPixels[] = new int[]{95,56,76,18,4,26,121,100,160,295,290,377,392,363,250};





  // ----- method -----

public MiddleCampus() {


  //color and font
  red = new Color(255, 0, 0); //RGB value
  headerFont = new Font("Times New Roman", Font.ITALIC + Font.BOLD, 28);
  cursorFont = new Font("Times New Roman", Font.ITALIC + Font.BOLD, 15);
  scoreFont = new Font("Times New Roman", Font.ITALIC + Font.BOLD, 23);
  scoreNumFont = new Font("Times New Roman", Font.ITALIC + Font.BOLD, 25);

  //LABELS
  headerLabel = new JLabel("Lake Forest College Middle Campus Game");
    headerLabel.setFont(headerFont);
    headerLabel.setForeground(red);
    headerLabel.setHorizontalAlignment(JLabel.CENTER);

  scoreLabel = new JLabel("Score:");
    scoreLabel.setFont(scoreFont);
    scoreLabel.setForeground(red);
    scoreLabel.setHorizontalAlignment(JLabel.RIGHT);//not center

  scoreNumLabel = new JLabel("10");
    scoreNumLabel.setFont(scoreNumFont);
    scoreNumLabel.setForeground(red);
    scoreNumLabel.setHorizontalAlignment(JLabel.LEFT); //underneath Score place


  //PANELS
  headerPanel = new JPanel();
    headerPanel.setPreferredSize(new Dimension(470, 70));
    headerPanel.setBackground(Color.BLACK);
    headerPanel.add(headerLabel, BorderLayout.CENTER);

  scorePanel = new JPanel();
    scorePanel.setPreferredSize(new Dimension(470, 70)); //adj dimensions
    scorePanel.setBackground(Color.BLACK);
    scorePanel.add(scoreLabel);

  //BACKGROUND PANEL
  background = new PictureBackgroundJPanel("bg.png");
    background.setBackground(Color.YELLOW);
    background.setLayout(null);

    Insets insets = background.getInsets();
    //BUTTONS
    for (int i = 0; i < buildings.length; i++){
      buildings[i] = new JButton();
        buildings[i].setFont(headerFont);
        buildings[i].setPreferredSize(new Dimension(widths[i], heights[1]));
        buildings[i].setBounds(xPixels[i] + insets.right, yPixels[i] + insets.top, widths[i], heights[i]);
        buildings[i].setBackground(red);//Set the background color (because it seems
        buildings[i].setOpaque(false);//that setOpaque doesn't work on buttons without doing thsi line first)
        background.add(buildings[i]);
    }



  //FRAME
  frame = new JFrame("Middle Campus");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(960, 560); //half dimension of full screen
    frame.setResizable(false);
    frame.add(background);
    frame.setVisible(true);


}

  public static void main(String[] args) {
    new MiddleCampus();
  }

}
