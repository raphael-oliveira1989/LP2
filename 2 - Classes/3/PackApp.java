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
	Arc a1,a2,a3;
	Triang t1;

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
		//Rect (int x, int y, int w, int h, Color bd, Color bg)
        this.r1 = new Rect(50,50, 100,30,Color.red,Color.gray);
		//Ellipse (int x, int y, int w, int h, Color bd, Color bg)
        this.e1 = new Ellipse(50,150, 100,30,Color.green,Color.magenta);
		//Arc (int x, int y, int w, int h, int arci, int arcf, Color bg)
		this.a1 = new Arc(200,100,50,50,0,270,Color.blue);
		this.a2 = new Arc(200,200,80,80,30,300,Color.yellow);
		this.a3 = new Arc(50,220,100,100,90,135,Color.cyan);
		this.e2 = new Ellipse(230,215, 15,15,Color.yellow,Color.black);
		//Triang (int x1,int x2,int x3,int y1,int y2,int y3, Color bd, Color bg)
		this.t1 = new Triang(100,130,200,250,200,300,Color.orange);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
		this.a1.paint_o(g);
		this.a2.paint_p(g);
		this.a3.paint_c(g);
		this.e2.paint(g);
		this.t1.paint(g);
	}
}