import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
						int x = rand.nextInt(300);
                        int y = rand.nextInt(300);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
						int bgr = rand.nextInt(255);
						int bgg = rand.nextInt(255);
						int bgb = rand.nextInt(255);
						int bdr = rand.nextInt(255);
						int bdg = rand.nextInt(255);
						int bdb = rand.nextInt(255);
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x,y, w,h,new Color(bgr,bgg,bgb),new Color(bdr,bdg,bdb)));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h,new Color(bgr,bgg,bgb),new Color(bdr,bdg,bdb)));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 'a') {
						int arci = rand.nextInt(180);
						int arcf = rand.nextInt(360);
						int choice = rand.nextInt(3);
                        figs.add(new Arc(x,y,w,h,arci,arcf,new Color(bgr,bgg,bgb),choice));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 't') {
						//int x1 = rand.nextInt(300);
                        int x2 = rand.nextInt(300);
						int x3 = rand.nextInt(300);
                        //int y1 = rand.nextInt(300);
						int y2 = rand.nextInt(300);
                        int y3 = rand.nextInt(300);
                        figs.add(new Triang(x,x2,x3,y,y2,y3,new Color(bgr,bgg,bgb)));
                        repaint();  // outer.repaint()
                    }
                }
            }
        );

        this.setTitle("Lista de Retangulos");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
