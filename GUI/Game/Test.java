import java.awt.*;
import javax.swing.*;

public class Test {
  JFrame frame;
  JPanel panel;
  PanelFilledWithPicture backgroundPic;

  public Test(){
    panel = new JPanel();
      panel.setPreferredSize(new Dimension(200,100));
      panel.setBackground(Color.BLACK);

    backgroundPic = new PanelFilledWithPicture();

    frame = new JFrame("jajjaja");
      frame.setSize(800,700);
      frame.add(backgroundPic);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
  }

  public static void main(String[] args) {
    Test test = new Test();
  }
}
