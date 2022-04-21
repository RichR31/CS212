/**
  * RigthWordsSalazar.java
  * @description main java class for the All The right Words game
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

public class RightWordsSalazar{
  // --- attributes ---
  private InstructionsPanel instructionsPanel;
  // --- methods ---

  /** constructor */
  public RightWordsSalazar(){
    instructionsPanel = new InstructionsPanel();

    /*instructionWindow = new Instructions();
    if(instructionWindow.getStartBtnFlag()){
      gameWindow.setFrameVisible();
    }*/
  }

  /** main method */
  public static void main(String[] args) {
    new RightWordsSalazar();
  }
}
