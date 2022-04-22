/**
  * CAPSJTextField.java
  * @description a custom class to make everything letter input as Capital letter
  * @version 1.0 2022-04-17
  * @author Ricardo Salazar
*/

import java.lang.Math;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;//https://www.tutorialspoint.com/swingexamples/add_border_to_panel.htm
import javax.swing.border.TitledBorder;
import javax.swing.text.*;

public class CAPSJTextField extends JTextField{
  //from: https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextField.html
  static int count = 0;
  public CAPSJTextField(){
    super();
  }

  protected Document createDefaultModel(){
    return new UpperCaseDocument();
  }

  static class UpperCaseDocument extends PlainDocument{
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{
      if(str == null){
        return;
      }
      char caps[] = str.toCharArray();
      for (int i = 0; i < caps.length; i++){
          caps[i] = Character.toUpperCase(caps[i]);
      }
      //System.out.println("In JTextField. Offset : " + offs );
      super.insertString(offs, new String(caps), a);
    }

  }


}
