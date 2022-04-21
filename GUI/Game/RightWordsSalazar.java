/**
  * RigthWordsSalazar.java
  * @description a class for GUI development for the game "All the right words"
  * @version 1.0 2022-03-19
  * @author Ricardo Salazar
*/
import java.lang.Math;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;//https://www.tutorialspoint.com/swingexamples/add_border_to_panel.htm
import javax.swing.border.TitledBorder;
import javax.swing.text.*;

public class RightWordsSalazar{
  // --- attributes ---
  /** Shared attributes */
  private Font F1, F2, F3, F4, F5;
  private final Color C1, C2, C3, C4, C5, C6;
  private final int FRAME_W, FRAME_H;
  private Border lineBdr;
  private ImageIcon testImage = new ImageIcon("bg.jpg");
  private ButtonResponse buttonResponse = new ButtonResponse();
  private TextChangeResponse textChangeResponse = new TextChangeResponse();
  /** attributes specific to the Instructions panel*/
  private String[] instructions = new String[]{
                                  "",
                                  "I'll give you 7 letters. You will have to create as",
                                  "many actual words as you can ;)" ,
                                  "I will score it based on the scrabble point values",
                                  "Oh! BTW watch out 'cause you will lose points when",
                                  "submiting an invalid word. Don't overthink it, you",
                                  "will get it on the way",
                                  "Just click \"Start!\""
                                };
  private JPanel startButtonContainerPn, instructionsContainerPn, fillerPn, lineGapPn, divisionLine1Pn, divisionLine2Pn, divisionLineContainer1Pn, divisionLineContainer2Pn;
  private JLabel welcomeLbl, gameTitleLbl, instructionsLbl, instructionsArray[] = new JLabel[instructions.length];
  private JButton startBtn;
  private JFrame instructionsFrame;
  private PictureBackgroundJPanel instructionsPanel;
  private TitledBorder instructionsTitledBdr;


  /** attributes specific to the Game panel */
  // --- attributes ---
  private JPanel /*gameBackgroundPanel,*/ editOptionsPn, topPn, letterBankPn, wordCountPn, wordCountInnerPn;
  private JFrame gameFrame;
  private JButton letterBtns[] = new JButton[7], clearBtn, submitBtn, finishBtn;
  private boolean isButtonEnabled[] = new boolean[7], wasEnteredByButton = false, flag = true;
  private CAPSJTextField currentWordTF;
  private JLabel validWordsLbl, totalPointsLbl;
  private String alphabet[] = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}, letterBank[] = new String[7], validWords = "";
  private String previousWordState=""; //this will store the previous state of the currentWordTF, before update the changes
  private int wordCount = 0, totalPoints = 0, maxIndexOfLettersEntered = -1, indexesOfLettersEntered[]=new int[7];
  private PictureBackgroundJPanel gameBackgroundPanel;
  private TitledBorder validWordsTitledBdr;//https://docs.oracle.com/javase/7/docs/api/javax/swing/BorderFactory.html#createTitledBorder(javax.swing.border.Border,%20java.lang.String,%20int,%20int,%20java.awt.Font

  // --- methods ---

  // method that generates randomly the letters of the button options
  public void generateLetterBank(){
    for(int i = 0; i < 7; i++){
      double rand = Math.random();
      int randIndex = (int) (rand * (alphabet.length - 1)); //studied this in highschool
      letterBank[i] = alphabet[randIndex];
    }
  }

  /** constructor */
  public RightWordsSalazar(){
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

    /** INTRUCTIONS UI */
    setIntructionsUI();

    /** GAME UI */
    setGameGUI();

    /** Main Frame */


  }


  public void setIntructionsUI(){
    /** Titled borders*/
    instructionsTitledBdr = BorderFactory.createTitledBorder(lineBdr, " How to play ", TitledBorder.CENTER, TitledBorder.TOP, F4, C5);

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



    /** The panel containing the information on how to play the game */
    instructionsLbl = new JLabel("Insert the instructions here");
      instructionsLbl.setPreferredSize(new Dimension(730, 30));
      instructionsLbl.setFont(F4);
      instructionsLbl.setForeground(C5);
      instructionsLbl.setHorizontalAlignment(JLabel.CENTER);

    /** The start Button */
    startBtn = new JButton("Start!");
      startBtn.setPreferredSize(new Dimension(500,100));
      startBtn.setFont(F2);
      startBtn.setToolTipText("Press only if you're actually ready");
      startBtn.setForeground(C4);

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
        startBtn.addActionListener(buttonResponse);


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


      }

    /**Background Panel for the Instructions UI*/
    instructionsPanel = new PictureBackgroundJPanel("instructionsbg.jpg");
      instructionsPanel.setBackground(C3);
      instructionsPanel.add(welcomeLbl);
      instructionsPanel.add(gameTitleLbl);
      instructionsPanel.add(instructionsContainerPn);
      instructionsPanel.add(startButtonContainerPn);

    instructionsFrame = new JFrame("All the right words");
      instructionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      instructionsFrame.setSize(FRAME_W, FRAME_H);
      instructionsFrame.setResizable(false);
      instructionsFrame.add(instructionsPanel);
      instructionsFrame.setVisible(true);

  }

  public void setGameGUI(){
    generateLetterBank();
    /** Titled borders*/
    validWordsTitledBdr = BorderFactory.createTitledBorder(lineBdr, " Your words submited", TitledBorder.RIGHT, TitledBorder.TOP, F5, Color.WHITE );

    /** Buttons */
    clearBtn = new JButton("Clear");
      clearBtn.setPreferredSize(new Dimension(130, 35));
      clearBtn.setFont(F3);
      clearBtn.setForeground(C4);
      clearBtn.addActionListener(buttonResponse);
    submitBtn = new JButton("Submit");
      submitBtn.setPreferredSize(new Dimension(130, 35));
      submitBtn.setFont(F3);
      submitBtn.setForeground(C4);
      submitBtn.addActionListener(buttonResponse);

    for(int i = 0; i < 7; i++){ //Assignment of the 7 letter buttons
      letterBtns[i]= new JButton(letterBank[i]);
      letterBtns[i].setFont(F1);
      letterBtns[i].addActionListener(buttonResponse);
      isButtonEnabled[i] = true;
    }
    finishBtn = new JButton("I give up!");
      finishBtn.setPreferredSize(new Dimension(500, 80));
      finishBtn.setFont(F2);
      finishBtn.setToolTipText("Press if you want to give UP");//https://docs.oracle.com/javase/tutorial/uiswing/components/tooltip.html
      finishBtn.setForeground(C4);
      finishBtn.addActionListener(buttonResponse);

    /** The current word Text Field */
    currentWordTF = new CAPSJTextField();
      currentWordTF.setFont(F1);
      currentWordTF.setPreferredSize(new Dimension(600, 80));
      currentWordTF.setHorizontalAlignment(JTextField.CENTER);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextField.html#setHorizontalAlignment(int)
      currentWordTF.setBorder(lineBdr);
      currentWordTF.addActionListener(buttonResponse);
      currentWordTF.getDocument().addDocumentListener(textChangeResponse);
      currentWordTF.getDocument().putProperty("name", "Text Field");

    /** The edit options panel */
    editOptionsPn = new JPanel();
      editOptionsPn.add(clearBtn);
      editOptionsPn.add(submitBtn);
      editOptionsPn.setPreferredSize(new Dimension(130, 80));
      editOptionsPn.setOpaque(false);

    /** The A label JComponent that contains all the valid words submited*/
    validWordsLbl = new JLabel(" You haven't enetered any valid words yet. Get to it! ");// use a JLabel better
      validWordsLbl.setPreferredSize(new Dimension(730,150));
      validWordsLbl.setFont(F5);
      validWordsLbl.setForeground(C5);
      validWordsLbl.setHorizontalAlignment(JLabel.CENTER);
      //validWordsLbl.setBackground(Color.BLACK);
      //validWordsLbl.setOpaque(true);

    totalPointsLbl = new JLabel("Total Points: 0");
      totalPointsLbl.setPreferredSize(new Dimension(730, 15));
      totalPointsLbl.setFont(F4);
      totalPointsLbl.setForeground(C5);
      totalPointsLbl.setHorizontalAlignment(JLabel.CENTER);
      //totalPointsLbl.setBackground(Color.BLACK);
      //totalPointsLbl.setOpaque(true);



    /** Top panel that will include the currentWordTF and the editOptionsPn */
    topPn = new JPanel();
      topPn.add(currentWordTF);
      topPn.add(editOptionsPn);
      topPn.setPreferredSize(new Dimension(740, 100));
      topPn.setOpaque(false);

    /** Letter Bank panel */
    letterBankPn = new JPanel();
      for(int x = 0; x < 7; x++){ //adding the letter Buttons to the panel
        letterBankPn.add(letterBtns[x]);
      }
      letterBankPn.setPreferredSize(new Dimension(735, 100));
      letterBankPn.setOpaque(false);


    /** a divisory line */
    divisionLine1Pn = new JPanel();
      divisionLine1Pn.setPreferredSize(new Dimension(732, 10));
      divisionLine1Pn.setBackground(C1);

    /** a divisory line */
    divisionLine2Pn = new JPanel();
      divisionLine2Pn.setPreferredSize(new Dimension(732, 10));
      divisionLine2Pn.setBackground(C1);


    divisionLineContainer1Pn = new JPanel();
      divisionLineContainer1Pn.setPreferredSize(new Dimension(750,20));
      divisionLineContainer1Pn.setOpaque(false);
      divisionLineContainer1Pn.add(divisionLine2Pn);


    divisionLineContainer2Pn = new JPanel();
      divisionLineContainer2Pn.setPreferredSize(new Dimension(750,25));
      divisionLineContainer2Pn.setOpaque(false);
      divisionLineContainer2Pn.add(divisionLine1Pn);


    /** inner JPanel container for the Word count Panel */
    wordCountInnerPn = new JPanel();
      wordCountInnerPn.setPreferredSize(new Dimension(710, 260));
      wordCountInnerPn.add(validWordsLbl, BorderLayout.PAGE_START);
      wordCountInnerPn.add(totalPointsLbl, BorderLayout.PAGE_END);
      wordCountInnerPn.setOpaque(true);
      wordCountInnerPn.setBackground(C6);


    /** The word count panel*/
    wordCountPn = new JPanel();
      wordCountPn.setPreferredSize(new Dimension(735, 300));
        wordCountPn.add(wordCountInnerPn);
        wordCountPn.setOpaque(false);
        wordCountPn.setBorder(validWordsTitledBdr);

    /** Background Panel of the game */
    gameBackgroundPanel = new PictureBackgroundJPanel("gamebg.jpg");
      gameBackgroundPanel.setBackground(C3);
      gameBackgroundPanel.add(topPn);
      gameBackgroundPanel.add(divisionLineContainer1Pn);
      gameBackgroundPanel.add(letterBankPn);
      gameBackgroundPanel.add(divisionLineContainer2Pn);
      gameBackgroundPanel.add(wordCountPn);
      gameBackgroundPanel.add(finishBtn);
      gameBackgroundPanel.setOpaque(true);

    gameFrame = new JFrame("All the right words");
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gameFrame.setSize(FRAME_W, FRAME_H);
      gameFrame.setResizable(false);
      gameFrame.add(gameBackgroundPanel);
      gameFrame.setVisible(false);
  }

  // Button listeners
  private class ButtonResponse implements ActionListener{
    public void actionPerformed(ActionEvent click){
      Object buttonClicked = click.getSource();
      String currentWordContent = currentWordTF.getText();
      /** Instructions */
      if(buttonClicked == startBtn){
        instructionsFrame.hide();
        gameFrame.setVisible(true);
      }

      /** GAME */
        /** clearBtn*/
        if(buttonClicked == clearBtn){
          currentWordContent = "";
          enableButtons();
        }
        /** submitBtn*/
        if(buttonClicked == submitBtn){
          System.out.println("Submit");
          wordCount++;

          validWords += currentWordContent + ", ";
          validWordsLbl.setText(validWords);
          currentWordContent = "";

          totalPoints += 5;//SET the point rules
          totalPointsLbl.setText("Total points: " + totalPoints);
          enableButtons();
        }
        //When press enter in the currentWordTF
        if(buttonClicked == currentWordTF){
          System.out.println("Entered");
          wordCount++;

          validWords += currentWordContent + ", ";
          validWordsLbl.setText(validWords);
          currentWordContent = "";

          totalPoints += 5;//SET the punctuation rules
          totalPointsLbl.setText("Total points: " + totalPoints);
          enableButtons();
        }
        /** Letter options*/
        for (int i = 0; i < 7; i++){
          //boolean flag = false;
          if(buttonClicked == letterBtns[i]){
            letterBtns[i].setEnabled(false);
            wasEnteredByButton= true;
            currentWordContent += letterBtns[i].getText();
            isButtonEnabled[i]= false;
          }

        }

        currentWordTF.setText(currentWordContent);
      }

      public void enableButtons(){
        for(int i = 0; i< 7; i++){
          isButtonEnabled[i] = true;
          letterBtns[i].setEnabled(true);
        }
      }
  } //ToDo better naming

  //Document Listener
  private class TextChangeResponse implements DocumentListener{

    public void insertUpdate(DocumentEvent e){
      if(wasEnteredByButton){
        wasEnteredByButton = false;
        return;
      }
      else{
        String currentWordContent = currentWordTF.getText();
        char charArray[] = currentWordContent.toCharArray();
        char insertedChar = charArray[e.getOffset()];
        int i = 0;
        boolean flag = true;
        while (flag && i<7){
          char buttonChar = letterBtns[i].getText().toCharArray()[0];
          if(buttonChar == insertedChar && isButtonEnabled[i]){
            letterBtns[i].setEnabled(false);
            isButtonEnabled[i]= false;
            flag=false;
          }
          i++;
        }
        previousWordState = currentWordContent;
      }
    }

    public void removeUpdate(DocumentEvent e){
      if (wasEnteredByButton){
        wasEnteredByButton = false;
        return;
      }
      char charArray[] = previousWordState.toCharArray();
      char removedChar = charArray[e.getOffset()];

      int i = 0;
      boolean flag = true;
      while (flag && i<7){
        char buttonChar = letterBtns[i].getText().toCharArray()[0];
        if(buttonChar == removedChar && !isButtonEnabled[i]){
          letterBtns[i].setEnabled(true);
          isButtonEnabled[i]= true;
          flag=false;
        }
        i++;
      }

    }

    public void changedUpdate(DocumentEvent e){
      //nothing because plaintext components do not trigger these events
    }
  }

  // --- main method ---
  public static void main(String[] args) {
    RightWordsSalazar test = new RightWordsSalazar();


  }



}
