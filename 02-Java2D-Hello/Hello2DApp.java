import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.blue);
        int w = getWidth();
        int h = getHeight();
		g2d.fillRect(0,0,w,h);
		g2d.setColor(Color.red);
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
		g2d.setColor(Color.black);
		g2d.fillRect(w/2,h/2,80,80);
		g2d.setColor(Color.green);
		g2d.drawOval(w/2,h/2,80,80);
    }
}