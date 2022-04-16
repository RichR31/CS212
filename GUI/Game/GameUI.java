/**
  * GameUI.java
  * @description The GUI of the game scene
  * @version 1.0 2022-04-11
  * @author Ricardo Salazar
*/
public class GameUI{
  // --- attributes ---
  private JPanel /*gameBackgroundPanel,*/ editOptionsPn, topPn, letterBankPn, wordCountPn, wordCountInnerPn;
  private JFrame gameFrame;
  private JButton letterBtns[] = new JButton[7], clearBtn, submitBtn, finishBtn;
  private JTextField currentWordTF;
  private JLabel validWordsLbl, totalPointsLbl;
  private String alphabet[] = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}, letterBank[] = new String[7], validWords = "";
  private int wordCount = 0, totalPoints = 0, maxIndexOfLettersEntered = -1, indexesOfLettersEntered[]=new int[7];
  private PictureBackgroundJPanel gameBackgroundPanel;

  // --- methods ---
  public GameUI(){
    generateLetterBank();
  }

  public void generateLetterBank(){
    for(int i = 0; i < 7; i++){
      double rand = Math.random();
      int randIndex = (int) (rand * (alphabet.length - 1)); //studied this in highschool
      letterBank[i] = alphabet[randIndex];
    }
  }




}
