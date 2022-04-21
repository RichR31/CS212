/**
  * Instructions.java
  * @description The panel containing the game Perse
  * @version 2.0 2022-04-18
  * @author Ricardo Salazar
*/

import javax.swing.JFrame;

public class Game extends JFrame{
  // --- attributes ---
  private final int FRAME_W, FRAME_H;
  private boolean startBtnFlag = false;
  /** constructor */
  public Game(){
    /** integers */
    FRAME_W = 800;
    FRAME_H = 700;
    setTitle("All the Right Words: Game");
    add(new GamePanel("gamebg.jpg"));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(FRAME_W, FRAME_H);
    setResizable(false);
    setVisible(false);
  }

  public void showGame(){
    setVisible(true);
  }

}
