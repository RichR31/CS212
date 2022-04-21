import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JavaExamleTooltipInJApplet extends JApplet
   {
     JButton BtnPrs = new JButton("Press Here");
     JTextField Txt = new JTextField(20);
     public void init()
        {
           Container Cntnr = getContentPane();
           Cntnr.setLayout(new FlowLayout());
           BtnPrs.setToolTipText("That is a Button.");
           Cntnr.add(BtnPrs);
           Cntnr.add(Txt);
           BtnPrs.addActionListener(new ActionListener()
              {
                 public void actionPerformed(ActionEvent e)
                  {
                     Txt.setText("Welcome To Java");
                  }
              });
         }
     }
