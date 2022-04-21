/**
  * Instructions.java
  * @description The First Frame containing the instructions before proceeding to the game
  * @version 2.0 2022-04-18
  * @author Ricardo Salazar
*/
import javax.swing.JFrame;

public class Instructions extends JFrame{
  // --- attributes ---
  private final int FRAME_W, FRAME_H;
  private boolean startBtnFlag = false;
  /** constructor */
  public Instructions(){

    /** integers */
    FRAME_W = 800;
    FRAME_H = 700;
    setTitle("All the Right Words: Instructions");
    add(new InstructionsPanel("instructionsbg.jpg"));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(FRAME_W, FRAME_H);
    setResizable(false);
    setVisible(true);
  }

  public boolean getStartBtnFlag(){
    return startBtnFlag;
  }
  public void hideInstructions(){
    setVisible(false);
  }
  /** main method */
  public static void main(String[] args) {
    new Instructions();
  }
}
