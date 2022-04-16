/**
  * Calculator.java
  * @description GUI for a calculator app
  * @version 1.0 2022-03-18
  * @author Ricardo Salazar
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorGUI extends JPanel{

  // --- attributes ---
  private JFrame frame;
  private JPanel bg, buttonPanel, textPanel, headerPanel;
  private JButton buttons[] = new JButton[16];
  private String buttonsText[] = new String[]{"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3","\u00d7", "C", "0", "=", "\u00F7"};
  private JTextField output;
  private Font calcFont, headerFont;
  private JLabel headerLabel;
  private Color purple;
  private ImageIcon koolAidMan;
  private Response userActivity = new Response();

  // --- methods ---

  /** Constructor */
  public CalculatorGUI(){
    setAssestsColorsAndFonts();
    setHeaderPanel();
    setTextPanel();
    setButtonsPanel();
    setBackgroundPanel();
  }

  private void setAssestsColorsAndFonts(){
    koolAidMan = new ImageIcon("img.png");

    purple = new Color(178, 34, 240);

    calcFont = new Font("Courier", Font.BOLD,  50);
    headerFont = new Font("Comic Sans MS", Font.BOLD, 30);
  }

  private void setHeaderPanel(){
    /** Label */
    headerLabel = new JLabel("My Fantastic calCOOLator", koolAidMan, SwingConstants.CENTER);
      headerLabel.setFont(headerFont);
      headerLabel.setForeground(purple);
      //headerLabel.setHorizontalAlignment(JLabel.CENTER);

    /** header panel */
    headerPanel = new JPanel();
      headerPanel.setPreferredSize(new Dimension(470, 70));
      headerPanel.setBackground(Color.BLACK);
      headerPanel.setLayout(new BorderLayout());
      headerPanel.add(headerLabel);//, BorderLayout.CENTER);
  }

  private void setTextPanel(){
    /** JTextField */
    output = new JTextField(20);
    //output.setEditable(false);
    output.setFont(calcFont);

    textPanel = new JPanel();
      textPanel.setLayout(new BorderLayout());
      textPanel.add(output, BorderLayout.CENTER);
      textPanel.setPreferredSize(new Dimension(470, 200));
  }

  private void setButtonsPanel(){

        buttonPanel = new JPanel();
          buttonPanel.setLayout(new GridLayout(4,4));
          /** buttons*/
          for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(buttonsText[i]);
            buttons[i].setFont(calcFont);
            buttons[i].addActionListener(userActivity);
            buttonPanel.add(buttons[i]);
          }
          buttonPanel.setPreferredSize(new Dimension(470, 470));
  }

  private void setBackgroundPanel(){
      setBackground(Color.BLACK);
      add(headerPanel);
      add(textPanel);
      add(buttonPanel);

      //TODO: choose a layout
  }

  private class Response implements ActionListener{
    public void actionPerformed(ActionEvent press){ //This method defines thr reaction the GUI should have
      if(press.getSource() == buttons[0]){
        output.setText(buttons[0].getText());
      }else if(press.getSource() == buttons[1]){
        output.setText(buttons[1].getText());
      }
    }
  }


  // --- main method ---
  public static void main(String[] args) {
    JFrame frame = new JFrame("My Calculator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(580, 780);
      frame.setResizable(false);
      frame.add(new CalculatorGUI());
      frame.setVisible(true);
  }
}
