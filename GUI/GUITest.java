import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.LayerUI;

//https://docs.oracle.com/javase/tutorial/uiswing/misc/jlayer.html
public class GUITest{
  // --- attributes ---

  // --- methods ---

  /** main method */
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        createUI();
      }
    });
  }

  /** createUI method */
  public static void createUI(){
    JFrame frame = new JFrame("This is a walpaper");

    JPanel panel = createPanel();
    LayerUI<JComponent> layerUI = new MyLayerUISubclass();
    JLayer<JComponent> jLayer = new JLayer<JComponent>(panel, layerUI);

    frame.add(jLayer);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
  private static JPanel createPanel() {
    JPanel p = new JPanel();

    ButtonGroup entreeGroup = new ButtonGroup();
    JRadioButton radioButton;
    p.add(radioButton = new JRadioButton("Beef", true));
    entreeGroup.add(radioButton);
    p.add(radioButton = new JRadioButton("Chicken"));
    entreeGroup.add(radioButton);
    p.add(radioButton = new JRadioButton("Vegetable"));
    entreeGroup.add(radioButton);

    p.add(new JCheckBox("Ketchup"));
    p.add(new JCheckBox("Mustard"));
    p.add(new JCheckBox("Pickles"));

    p.add(new JLabel("Special requests:"));
    p.add(new JTextField(20));

    JButton orderButton = new JButton("Place Order");
    p.add(orderButton);

    return p;
  }

}

class MyLayerUISubclass extends LayerUI<JComponent>{
  @Override
  public void paint(Graphics g, JComponent c) {
  super.paint(g, c);

  Graphics2D g2 = (Graphics2D) g.create();

  int w = c.getWidth();
  int h = c.getHeight();
  g2.setComposite(AlphaComposite.getInstance(
          AlphaComposite.SRC_OVER, .5f));
  g2.setPaint(new GradientPaint(0, 0, Color.yellow, 0, h, Color.red));
  g2.fillRect(0, 0, w, h);

  g2.dispose();
  }
}
