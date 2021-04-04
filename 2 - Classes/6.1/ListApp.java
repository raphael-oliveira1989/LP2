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
						/*
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
						*/
                        figs.add(new Rect(x,y, w,h,new Color(bgr,bgg,bgb),new Color(bdr,bdg,bdb)));
                        repaint();  // outer.repaint()
                    }
					else if (evt.getKeyChar() == 'e') {
						/*
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
						*/
                        figs.add(new Ellipse(x,y, w,h,new Color(bgr,bgg,bgb),new Color(bdr,bdg,bdb)));
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
