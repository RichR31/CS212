/**
  * Game.java
  * @description The Frame containing all the elements for the game
  * @version 2.0 2022-04-18
  * @author Ricardo Salazar
*/

import java.util.ArrayList;
import java.lang.Math;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.*;

public class GamePanel extends PictureBackgroundJPanel{
  // --- attributes ---
  private Font F1, F2, F3, F4, F5;
  private final Color C1, C2, C3, C4, C5, C6, RED, GREEN;
  private Border lineBdr, dashBorder;

  private JPanel  editOptionsPn, topPn, letterBankPn, wordCountPn, wordCountInnerPn, startButtonContainerPn, instructionsContainerPn, fillerPn, lineGapPn, divisionLine1Pn, divisionLine2Pn, divisionLineContainer1Pn, divisionLineContainer2Pn;
  private JButton letterBtns[] = new JButton[7], clearBtn, submitBtn, finishBtn;
  private boolean wasEnteredByClick = false;
  private CAPSJTextField currentWordTF;
  private JLabel validWordsLbl, totalPointsLbl, additionalInfoLbl;
  private GameBrain gameBrain = new GameBrain();
  private String  letterBank[] = gameBrain.getLetters();
  private ArrayList<String> validWords = new ArrayList<String>();
  private ArrayList<Integer> disabledButtonIndexes = new ArrayList<Integer>();
  private String currentWordContent = ""; //this will store the previous state of the currentWordTF, before update the changes
  private int wordCount = 0, totalPoints = 0;
  private TitledBorder validWordsTitledBdr;//https://docs.oracle.com/javase/7/docs/api/javax/swing/BorderFactory.html#createTitledBorder(javax.swing.border.Border,%20java.lang.String,%20int,%20int,%20java.awt.Font
  private ButtonResponse buttonResponse = new ButtonResponse();
  private TextChangeResponse textChangeResponse = new TextChangeResponse();

  // --- methods ---
    /** Constructor */
    public GamePanel(String bgName){
      super(bgName);

      /** Colors */
      C1 = new Color(2,83,133);
      C2 = new Color(4,226,183);
      C3 = new Color(3,130,152);
      C4 = new Color(1,82,104);
      C5 = new Color(23,35,71);
      C6 = new Color(208, 229, 217);
      RED = new Color(226,72,72);
      GREEN = new Color(40,133,62);

      /** Fonts */
      F1 = new Font("Courier", Font.BOLD, 37);//https://docs.oracle.com/javase/7/docs/api/java/awt/Font.html
      F2 = new Font("Courier", Font.PLAIN, 35);
      F3 = new Font("Courier", Font.PLAIN, 27);
      F4 = new Font("Courier", Font.PLAIN, 20);
      F5 = new Font("Courier", Font.PLAIN, 15);

      /** regular borders */
      lineBdr = BorderFactory.createLineBorder(C5, 2, true);
      /** Titled borders*/
      validWordsTitledBdr = BorderFactory.createTitledBorder(lineBdr, " Your words submited", TitledBorder.RIGHT, TitledBorder.TOP, F5, Color.WHITE );
      gameBrain = new GameBrain();

      setButtons();
      setTextField();
      setLabels();
      setEditOptionsPanel();
      setTopPanel();
      setLetterBankPanel();
      setDivisionContainers();
      setWordCountPanel();

      add(additionalInfoLbl);
      add(topPn);
      add(divisionLineContainer1Pn);
      add(letterBankPn);
      add(divisionLineContainer2Pn);
      add(wordCountPn);
      add(finishBtn);
      //this.setOpaque(true);

    }

    public void setButtons(){
      /** Buttons */
      clearBtn = new JButton("Clear");
        clearBtn.setPreferredSize(new Dimension(130, 35));
        clearBtn.setFont(F3);
        clearBtn.setForeground(C4);
        clearBtn.addActionListener(buttonResponse);
        clearBtn.setFocusable(false);
      submitBtn = new JButton("Submit");
        submitBtn.setPreferredSize(new Dimension(130, 35));
        submitBtn.setFont(F3);
        submitBtn.setForeground(C4);
        submitBtn.addActionListener(buttonResponse);
        submitBtn.setFocusable(false);

      for(int i = 0; i < 7; i++){ //Assignment of the 7 letter buttons
        letterBtns[i]= new JButton(letterBank[i]);
        letterBtns[i].setFont(F1);
        letterBtns[i].setPreferredSize(new Dimension(80,80));
        letterBtns[i].addActionListener(buttonResponse);
        letterBtns[i].setFocusable(false);
      }
      finishBtn = new JButton("I give up!");
        finishBtn.setPreferredSize(new Dimension(400, 50));
        finishBtn.setFont(F3);
        finishBtn.setToolTipText("Press if you want to give UP");//https://docs.oracle.com/javase/tutorial/uiswing/components/tooltip.html
        finishBtn.setForeground(C4);
        finishBtn.addActionListener(buttonResponse);
        finishBtn.setFocusable(false);
    }

    public void setTextField(){
      /** The current word Text Field */
      currentWordTF = new CAPSJTextField();
        currentWordTF.setFont(F1);
        currentWordTF.setPreferredSize(new Dimension(600, 80));
        currentWordTF.setHorizontalAlignment(JTextField.CENTER);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextField.html#setHorizontalAlignment(int)
        currentWordTF.setBorder(lineBdr);
        currentWordTF.addActionListener(buttonResponse);
        currentWordTF.getDocument().addDocumentListener(textChangeResponse);
        currentWordTF.getDocument().putProperty("name", "Text Field");
    }

    public void setLabels(){
      /** The A label JComponent that contains all the valid words submited*/
      validWordsLbl = new JLabel(" You haven't entered any valid words yet. Get to it! ");// use a JLabel better
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

      additionalInfoLbl = new JLabel("Let's Go!");
        additionalInfoLbl.setPreferredSize(new Dimension(720,22));
        additionalInfoLbl.setHorizontalAlignment(JLabel.CENTER);
        additionalInfoLbl.setBackground(Color.WHITE);
        additionalInfoLbl.setOpaque(true);
        additionalInfoLbl.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 10, C5));
        additionalInfoLbl.setForeground(C5);

    }

    public void setEditOptionsPanel(){
      /** The edit options panel */
      editOptionsPn = new JPanel();
        editOptionsPn.add(clearBtn);
        editOptionsPn.add(submitBtn);
        editOptionsPn.setPreferredSize(new Dimension(130, 80));
        editOptionsPn.setOpaque(false);
    }


    public void setTopPanel(){
      /** Top panel that will include the currentWordTF and the editOptionsPn */
      topPn = new JPanel();
        topPn.add(currentWordTF);
        topPn.add(editOptionsPn);
        topPn.setPreferredSize(new Dimension(740, 92));
        topPn.setOpaque(false);
    }

    public void setLetterBankPanel(){
      letterBankPn = new JPanel();
        for(int x = 0; x < 7; x++){ //adding the letter Buttons to the panel
          letterBankPn.add(letterBtns[x]);
        }
        letterBankPn.setPreferredSize(new Dimension(735, 100));
        letterBankPn.setOpaque(false);
    }

    public void setDivisionContainers(){
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
    }

    public void setWordCountPanel(){
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
      }

    // Button listeners
    private class ButtonResponse implements ActionListener{
      public void actionPerformed(ActionEvent click){
        Object buttonClicked = click.getSource();
          /** clearBtn*/
          if(buttonClicked == clearBtn){
            clearTextField();
          }
          /** submitBtn*/
          if(buttonClicked == submitBtn){
            tryToSubmitWord("Button.");
          }
          //When press enter in the currentWordTF
          if(buttonClicked == currentWordTF){
            tryToSubmitWord("Enter");
          }
          /** Letter options*/  // B I R S I W A
          for (int i = 0; i < 7; i++){ //de 0 a 7
            if(buttonClicked == letterBtns[i]){ //S 3
              letterBtns[i].setEnabled(false);
              disabledButtonIndexes.add(i); //3
              wasEnteredByClick= true;
              currentWordContent += letterBtns[i].getText();
              currentWordTF.setText(currentWordContent);
              break;
            }

          }
        }

      public void clearTextField(){
        wasEnteredByClick = true;
        currentWordContent = "";
        enableButtons();
        currentWordTF.setText(currentWordContent);

      }

      public void enableButtons(){
        for(int i = 0; i< 7; i++){
          if(disabledButtonIndexes.contains(Integer.valueOf(i))){
            letterBtns[i].setEnabled(true);
            int index = disabledButtonIndexes.indexOf(Integer.valueOf(i));
            disabledButtonIndexes.remove(index);
          }

        }
      }

      public void updateScoreAndWordCount(){
        int points = gameBrain.scoreOf(currentWordContent);
        totalPoints += points;
        wordCount++;
        totalPointsLbl.setText("Score: " + totalPoints + ". Words: " + wordCount);
      }

      public void submitWord(String type){
        validWords.add(currentWordTF.getText());
        validWordsLbl.setText(validWordsToString());
        updateScoreAndWordCount();
        clearTextField();
        System.out.println("Submited by " + type);
      }

      public void tryToSubmitWord(String type){
        if(!currentWordContent.equals("")){
          if(gameBrain.isValid(currentWordContent)){
            if(gameBrain.isFromLetterBank(currentWordContent, letterBank)){
              if(!validWords.contains(String.valueOf(currentWordContent))){
                updateAdditionalInfoLabel("Good job!! \"" + currentWordTF.getText() + "\" is a great word" , "increase");
                submitWord(type);
              }else{
                updateAdditionalInfoLabel("Hey -_- I saw what you did there!! you submited \"" + currentWordTF.getText() + "\" before. Don't try to cheat, >:( -2 points" , "penalty");
                totalPoints-=2;
                clearTextField();
              }

            } else{
              updateAdditionalInfoLabel("It seems like you didn't use the word bank options to spell \"" + currentWordTF.getText() + "\". -2 points", "penalty");
              totalPoints-=2;
              clearTextField();
            }
          } else{
            updateAdditionalInfoLabel(("\"" + currentWordTF.getText() + "\" is not a valid word. " + " -2 points"), "penalty");
            totalPoints-=2;
            clearTextField();
          }
        } else{
          System.out.println("Empty entry");

        }
      }

      public String validWordsToString(){
        String s = "";
        for ( int i = 0; i < validWords.size(); i++){
          if (i == validWords.size()-1){
            s += validWords.get(i);
          }else{
            s += validWords.get(i) + ", ";
          }

        }
        return s;
      }

      //update the label with additional info types : normal(0), increase(1), decrease(2),
      public void updateAdditionalInfoLabel(String note, String type){
        switch (type){
          case "normal":
            additionalInfoLbl.setForeground(C5);
            additionalInfoLbl.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 10, C5));
            break;
          case "increase":
            additionalInfoLbl.setForeground(GREEN);
            additionalInfoLbl.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 10, GREEN));
            break;
          case "penalty":
            additionalInfoLbl.setForeground(RED);
            additionalInfoLbl.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 10, RED));
            break;
          default:
            break;

        }
        additionalInfoLbl.setText(note);

      }



    }

    //Document Listener
    private class TextChangeResponse implements DocumentListener{

      public void insertUpdate(DocumentEvent e){
        if(wasEnteredByClick){
          wasEnteredByClick = false;
          return;
        }// 0,1, 2, 3
        else{ // B I R S I W A

          String currentInput = currentWordTF.getText();//IWAB
          System.out.println(" current "+ currentInput);
          for( int i = 0; i<7; i++){
            if(!disabledButtonIndexes.contains(Integer.valueOf(i))){
              char insertedChar = currentInput.charAt(e.getOffset());//B
              System.out.println("Character:" + insertedChar);
              char buttonChar = letterBtns[i].getText().charAt(0);
              if(buttonChar == insertedChar){
                letterBtns[i].setEnabled(false);
                disabledButtonIndexes.add(i);
                currentWordContent = currentInput;
                break;
              }
            }
          }
        }
      }

      public void removeUpdate(DocumentEvent e){
        if (wasEnteredByClick){
          wasEnteredByClick = false;
          return;
        }else { // IWAB (B I R S I W A)
          String previousWord = currentWordContent;
          for(int i = 0; i < 7; i++){
            if(disabledButtonIndexes.contains(Integer.valueOf(i))){
              char removedChar = previousWord.charAt(e.getOffset());
              char buttonChar = letterBtns[i].getText().charAt(0);
              if(buttonChar == removedChar){
                letterBtns[i].setEnabled(true);
                int index = disabledButtonIndexes.indexOf(Integer.valueOf(i));
                disabledButtonIndexes.remove(index);
                currentWordContent = currentWordTF.getText();
                break;
              }
            }
          }
        }


      }

      public void changedUpdate(DocumentEvent e){
        //nothing because plaintext components do not trigger these events
      }
    }


}
