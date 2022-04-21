import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.AWTEventListener;

import javax.swing.*;

public class FollowTip {
  //Java Swing: "permanent tooltip" hint that follows mouse cursor on App's JFrame - Stack Overflow
    private JWindow tip;

    private final AWTEventListener mouseHandler = e -> {
        Window window = tip.getOwner();
        MouseEvent event = null;

        switch (e.getID()) {
            case MouseEvent.MOUSE_ENTERED:
            case MouseEvent.MOUSE_MOVED:
            case MouseEvent.MOUSE_DRAGGED:
                event = (MouseEvent) e;
                if (window.isAncestorOf(event.getComponent())) {
                    Point loc = event.getLocationOnScreen();
                    tip.setLocation(loc.x + 10, loc.y + 10);
                    tip.setVisible(true);
                }
                break;
            case MouseEvent.MOUSE_EXITED:
                event = (MouseEvent) e;
                Point p = SwingUtilities.convertPoint(
                    event.getComponent(), event.getPoint(), window);
                if (!window.contains(p)) {
                    tip.setVisible(false);
                }
                break;
            default:
                break;
        }
    };

    public FollowTip(String text,
                     Window window) {

        JLabel tipLabel = new JLabel(text);

        //The label
        tipLabel.setForeground(Color.BLACK);
        tipLabel.setBackground(Color.GRAY);
        tipLabel.setOpaque(true);
        tipLabel.setFont(UIManager.getFont("ToolTip.font"));
        tipLabel.setBorder(UIManager.getBorder("ToolTip.border"));


        tip = new JWindow(window);
        tip.setType(Window.Type.POPUP);
        tip.setFocusableWindowState(false);
        tip.getContentPane().add(tipLabel);
        tip.pack();
    }

    public void activate() {
        Window window = tip.getOwner();
        window.getToolkit().addAWTEventListener(mouseHandler,
            AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);

        Point p = window.getMousePosition();
        if (p != null) {
            SwingUtilities.convertPointToScreen(p, window);
            tip.setLocation(p.x + 10, p.y + 10);
            tip.setVisible(true);
        }
    }

    public void deactivate() {
        Window window = tip.getOwner();
        window.getToolkit().removeAWTEventListener(mouseHandler);

        tip.setVisible(false);
    }

    static void showWindow() {
        JToggleButton button = new JToggleButton("Active");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);

        JFrame frame = new JFrame("MiddleCampus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane());
        frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setSize(960, 560);
        frame.setVisible(true);

        FollowTip tip = new FollowTip("Click on Blackstone", frame);
        tip.activate();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> showWindow());
    }
}
