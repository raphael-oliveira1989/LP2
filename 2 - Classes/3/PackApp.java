import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1,e2;
	Arc a1;
	Arc a2;
	Arc a3;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30,0,255,0,166,166,166);
        this.e1 = new Ellipse(50,150, 100,30,255,0,0,0,255,255);
		this.a1 = new Arc(200,100,50,50,0,270,0,0,0);
		this.a2 = new Arc(200,200,80,80,30,300,255,255,0);
		this.a3 = new Arc(50,220,50,50,90,180,0,255,0);
		this.e2 = new Ellipse(230,215, 15,15,0,0,0,0,0,0);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
		this.a1.paint_o(g);
		this.a2.paint_p(g);
		this.a3.paint_c(g);
		this.e2.paint(g);
	}
}