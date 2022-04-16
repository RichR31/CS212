/**
  * calculatorGUI.java
  * @description Example with buttons and text box
  * @author SJ Zelenberg
  * @version 1.0 03-18-2022
*/


import java.awt.*;
import java.awt.event.*; // do you need this?
import javax.swing.*;

public class CalculatorGUI extends JPanel{

  // ----- attributes -----
  //private JFrame frame;
  private JPanel buttonPanel, textPanel, headerPanel;
  private JButton buttonArray[] = new JButton[16];
  private String buttonText[] = {"7", "8", "9", "+", "4", "5", "6", "-",
                                 "1", "2", "3", "\u00D7", "C", "0", "=",
                                 "\u00F7"};
  private JTextField output;
  private Font calcFont, headerFont;
  private JLabel headerLabel, imageLabel, imageLabel2;
  private Color purple;
  private ImageIcon koolAidMan;
  private Response userActivity = new Response();

  // ----- method -----

  public CalculatorGUI(){

    setFontsColorsAndImages();
    setLabels();
    setHeaderPanel();
    setTextPanel();
    setButtonPanel();
    placeElementsinFrame();
  }

  private void setFontsColorsAndImages(){
    // Fonts
    headerFont = new Font("Times New Roman", Font.ITALIC + Font.BOLD, 28);
    calcFont = new Font("Courier", Font.BOLD, 50);

    // Images
    koolAidMan = new ImageIcon("pics/Kool-Aid_Man.png");

    // Color
    purple = new Color(178,34,240); //RGB value
  }

  private void setLabels(){
    // Labels
    imageLabel = new JLabel(koolAidMan);
    imageLabel2 = new JLabel(koolAidMan);

    headerLabel = new JLabel("My Fabulous Calcoolator");
      headerLabel.setFont(headerFont);
      headerLabel.setForeground(purple);
      headerLabel.setHorizontalAlignment(JLabel.CENTER); // Ref: Ricardo Salazar

  }

  private void setHeaderPanel(){
    headerPanel = new JPanel();
      headerPanel.setPreferredSize(new Dimension(470, 70));
      headerPanel.setBackground(Color.BLACK);
      headerPanel.setLayout(new BorderLayout());
      headerPanel.add(headerLabel, BorderLayout.CENTER);
      headerPanel.add(imageLabel, BorderLayout.EAST);
      headerPanel.add(imageLabel2, BorderLayout.WEST);
  }

  private void setTextPanel(){
    // text field
    output = new JTextField(20);
    output.setEditable(false); // cannot type on it
    output.setFont(calcFont);

    // Panels
    textPanel = new JPanel();
      textPanel.setLayout(new BorderLayout());
      textPanel.add(output, BorderLayout.CENTER);
      textPanel.setPreferredSize(new Dimension(470, 100));

  }

  private void setButtonPanel(){
    buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(4, 4));
      // Buttons
      for (int i=0; i<buttonArray.length; i++){
        buttonArray[i] = new JButton(buttonText[i]); // do we need new?
        buttonArray[i].setFont(calcFont);
        // to each button we add an action listener object
        buttonArray[i].addActionListener(userActivity);
        buttonPanel.add(buttonArray[i]);
      }

      buttonPanel.setPreferredSize(new Dimension(470, 470));
  }

  private void placeElementsinFrame(){
    setBackground(Color.GRAY);
    add(headerPanel);
    add(textPanel);
    add(buttonPanel);
  }

  /** define respond to elements of gui */
  private class Response implements ActionListener{

    public void actionPerformed(ActionEvent press){
      if (press.getSource() == buttonArray[0]){
        output.setText(buttonArray[0].getText());
      } else if (press.getSource() == buttonArray[1]){
        output.setText("8");
      }

    }
  }

  public static void main(String[] args) {
    // Frame
    JFrame frame = new JFrame("My Calculator!");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(580, 720);
      frame.setResizable(false);
      frame.add(new CalculatorGUI() );
      frame.setVisible(true);
  }

}
