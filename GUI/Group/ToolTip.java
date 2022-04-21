import java.awt.*;
import javax.swing.*;
import javax.swing.ToolTipManager.*;
import javax.swing.border.Border;
import java.awt.event.MouseEvent;
import java.awt.event.AWTEventListener.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class ToolTip{
  // --- attributes ---
  private JWindow tip;
  private Font font;
  private Border border;
  private String currentBuildingName = "";
  // --- methods ---

  /** Constructor */
  private ToolTip (Window window){
    this.currentBuildingName = currentBuildingName;
    font = new Font("Courier", Font.PLAIN, 20);
    border = BorderFactory.createLineBorder(Color.BLACK);

    JLabel tiplabel = new JLabel("Click on" +  this.currentBuildingName);
      tiplabel.setForeground(Color.BLACK);
      tiplabel.setBackground(Color.WHITE);
      tiplabel.setBorder(border);
      tiplabel.setOpaque(true);

    tip = new JWindow(window);
      tip.setType(Window.Type.POPUP);
      tip.setFocusable(false);
      tip.getContentPane().add(tiplabel);
      tip.pack();
  }

  private final AWTEventListener mouseHandler = e ->{
    Window window = tip.getOwner();
    MouseEvent event = null;

    switch (e.getID()) {
      case MouseEvent.MOUSE_ENTERED:
      case MouseEvent.MOUSE_MOVED:
      case MouseEvent.MOUSE_DRAGGED:
        event = (MouseEvent) e;
        if (window.isAncestorOf(event.getComponent())){
          Point loc = event.getLocationOnScreen();
          tip.setLocation(loc.x + 10, loc.y + 10);
          tip.setVisible(true);
        }
        break;

      case MouseEvent.MOUSE_EXITED:
        event = (MouseEvent) e;
        Point p = SwingUtilities.convertPoint(event.getComponent(), event.getPoint(), window);
        if (!window.contains(p)){
          tip.setVisible(false);
        }
        break;
      default:
        break;
    }
  };

    public void activate(){
      Window window = tip.getOwner();
      window.getToolkit().addAWTEventListener(mouseHandler, AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);

      Point p = window.getMousePosition();
      if(p != null){
        SwingUtilities.convertPointToScreen(p, window);
        tip.setLocation(p.x + 10, p.y + 10);
        tip.setVisible(true);
      }

    }

    public void deactivate(){
      Window window = tip.getOwner();
      window.getToolkit().removeAWTEventListener(mouseHandler);

      tip.setVisible(false);

    }


    public static void main(String[] args) {
      MiddleCampus campus = new MiddleCampus();
      ToolTip tip = new ToolTip(campus.getFrame());
      tip.activate();
    }



}
