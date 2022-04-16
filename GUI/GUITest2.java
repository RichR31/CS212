import java.awt.*;
import javax.swing.*;

public class GUITest2{
  // --- attributes ---
  private JFrame frame;
  private JPanel panel;
  private JButton button;
  private ImageIcon iconBG;



  // --- methods ---
  /** constructor */
  public GUITest2(){
    iconBG = new ImageIcon("img/buttonbg.png", "background");

    button = new JButton("Click me");
      button.setBackground(Color.GREEN);
      button.setOpaque(true);


    panel = new JPanel();
      panel.setPreferredSize(new Dimension(1280,720));
      panel.setBackground(Color.GRAY);
      panel.add(button);

    frame = new JFrame("This is a test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1280,720);
      frame.setBackground(Color.WHITE);
      frame.add(panel);
      frame.setVisible(true);
  }

  /** main method */
  public static void main(String[] args) {
    GUITest2 test = new GUITest2();

  }
}
