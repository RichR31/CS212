import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUpJava {
  public PopUpJava(){
    JFrame jFrame = new JFrame();//Game Frame
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setSize(600, 600);

    JDialog jd = new JDialog(jFrame);

    JLabel jLabel = new JLabel("Press close button to close the dialog.");

    JButton jButton = new JButton("Close");
    jButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jd.setVisible(false);
            jFrame.setVisible(true);
        }
    });

    jd.add(jLabel);
    jd.add(jButton);
    jd.setVisible(true);
  }
  public static void main(String[] args) {
    PopUpJava test = new PopUpJava();
  }
}
