/**
  * InstructionsPanel.java
  * @description The panel containing the Instructions for the game
  * @version 2.0 2022-04-18
  * @author Ricardo Salazar
*/

import java.lang.Math;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.*;

public class InstructionsPanel{
  // --- attributes ---
    private Font F1, F2, F3, F4, F5;
    private final Color C1, C2, C3, C4, C5, C6;
    private final int FRAME_W, FRAME_H;
    private Border lineBdr;
    private String[] instructions = new String[]{
                                    "",
                                    "I'll give you 7 letters. You will have to create as",
                                    "many actual words as you can ;)" ,
                                    "I will score it based on the scrabble point values",
                                    "Oh! BTW watch out 'cause you will lose points when",
                                    "submiting an invalid word. Don't overthink it tho",
                                    "you will get it on the way",
                                    "Just click \"Start!\""
                                  };
    private JPanel startButtonContainerPn, instructionsContainerPn, fillerPn, lineGapPn, divisionLine1Pn, divisionLine2Pn, divisionLineContainer1Pn, divisionLineContainer2Pn;
    private JLabel welcomeLbl, gameTitleLbl, instructionsLbl, additionalLbl1, additionalLbl2, instructionsArray[] = new JLabel[instructions.length];
    private JButton startBtn;
    private JFrame instructionsFrame;
    private PictureBackgroundJPanel instructionsPanel;
    private TitledBorder instructionsTitledBdr;
    private ButtonResponse buttonResponse = new ButtonResponse();
    private JDialog jDialog;
    private Game gameFrame;

  // --- methods ---
    /** Constructor */
    public InstructionsPanel(){

      /** integers */
      FRAME_W = 800;
      FRAME_H = 700;

      /** Colors */
      C1 = new Color(2,83,133);
      C2 = new Color(4,226,183);
      C3 = new Color(3,130,152);
      C4 = new Color(1,82,104);
      C5 = new Color(23,35,71);
      C6 = new Color(208, 229, 217);

      /** Fonts */
      F1 = new Font("Courier", Font.BOLD, 70);//https://docs.oracle.com/javase/7/docs/api/java/awt/Font.html
      F2 = new Font("Courier", Font.PLAIN, 35);
      F3 = new Font("Courier", Font.PLAIN, 27);
      F4 = new Font("Courier", Font.PLAIN, 20);
      F5 = new Font("Courier", Font.PLAIN, 15);

      /** regular borders */
      lineBdr = BorderFactory.createLineBorder(C5, 2, true);
      /** Titled borders*/
      instructionsTitledBdr = BorderFactory.createTitledBorder(lineBdr, " How to play ", TitledBorder.CENTER, TitledBorder.TOP, F4, C5);

      setWelcomeAndTitleLabel();
      setInstructionsContainer();
      setStartButtonContainer();
      setPicturePanel();
      setJDialog();


    }

    public void setWelcomeAndTitleLabel(){
      /** welcome label */
      welcomeLbl = new JLabel(" Welcome! ");
        welcomeLbl.setPreferredSize(new Dimension(FRAME_W, 60));
        welcomeLbl.setFont(F2);
        welcomeLbl.setForeground(Color.WHITE);
        welcomeLbl.setHorizontalAlignment(JLabel.CENTER);

      gameTitleLbl = new JLabel(" This is the \"All the right Words\"® game ");
        gameTitleLbl.setPreferredSize(new Dimension(700, 50));
        gameTitleLbl.setFont(F3);
        gameTitleLbl.setForeground(Color.WHITE);
        gameTitleLbl.setHorizontalAlignment(JLabel.CENTER);

      additionalLbl1 = new JLabel("(aka scrabble for lonely people)");
        additionalLbl1.setFont(F5);
        additionalLbl1.setForeground(Color.WHITE);
        additionalLbl1.setHorizontalAlignment(JLabel.CENTER);

      additionalLbl2 = new JLabel("PS: Scrabble pls don't sue us");
        additionalLbl2.setFont(F5);
        additionalLbl2.setForeground(Color.WHITE);
        additionalLbl2.setHorizontalAlignment(JLabel.LEFT);
    }

    public void setStartButtonContainer(){
      /** The start Button */
      startBtn = new JButton("Start!");
        startBtn.setPreferredSize(new Dimension(500,100));
        startBtn.setFont(F2);
        startBtn.setToolTipText("Press only if you're actually ready");
        startBtn.setForeground(C4);
        startBtn.setFocusable(false);
        startBtn.addActionListener(buttonResponse);

      /** just an empty panel to ajust the composition of the StartBtn */
      fillerPn = new JPanel();
        fillerPn.setPreferredSize(new Dimension(FRAME_W, 50));
        fillerPn.setOpaque(false);

      /** A container panel for the start button */
      startButtonContainerPn = new JPanel();
          startButtonContainerPn.setPreferredSize(new Dimension(FRAME_W, 200));
          startButtonContainerPn.add(fillerPn);
          startButtonContainerPn.add(startBtn);
          startButtonContainerPn.setOpaque(false);
          //startBtn.addActionListener(buttonResponse);
      }

    public void setInstructionsContainer(){
        instructionsContainerPn = new JPanel();
          instructionsContainerPn.setPreferredSize(new Dimension(650, 300));
          //instructionsContainerPn.add(instructionsLbl);
          instructionsContainerPn.setOpaque(false);
          instructionsContainerPn.setBorder(instructionsTitledBdr);
          for(int i = 0; i < instructionsArray.length; i++){
            instructionsArray[i] = new JLabel(instructions[i]);
            instructionsContainerPn.add(instructionsArray[i]);
            instructionsArray[i].setPreferredSize(new Dimension(580, 25));
            instructionsArray[i].setFont(new Font("Courier", Font.PLAIN, 18));
            instructionsArray[i].setForeground(Color.WHITE);
            instructionsArray[i].setHorizontalAlignment(JLabel.CENTER);
          }
      }

    public void setPicturePanel(){
      instructionsPanel = new PictureBackgroundJPanel("instructionsbg.jpg");
        instructionsPanel.add(welcomeLbl);
        instructionsPanel.add(gameTitleLbl);
        instructionsPanel.add(additionalLbl1);
        instructionsPanel.add(instructionsContainerPn);
        instructionsPanel.add(additionalLbl2);
        instructionsPanel.add(startButtonContainerPn);
    }

    public void setJDialog(){
      gameFrame = new Game();
      jDialog = new JDialog(gameFrame);
        jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jDialog.add(instructionsPanel);
        jDialog.setSize(FRAME_W, FRAME_H);
        jDialog.setVisible(true);
    }

    private class ButtonResponse implements ActionListener{
      public void actionPerformed(ActionEvent click){
        jDialog.setVisible(false);
        gameFrame.showGame();
      }
    }

}
