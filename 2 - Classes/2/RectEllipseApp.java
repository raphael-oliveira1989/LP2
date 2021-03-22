import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Rect r1;
	Rect r2;
	Rect r3;
    Ellipse e1,e2,e3;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30,0,255,0,166,166,166);
		this.r2 = new Rect(200,50, 80,50,0,0,0,255,17,56);
		this.r3 = new Rect(50,100, 10,30,255,0,0,133,0,166);
        this.e1 = new Ellipse(50,200, 100,30, 0,255,0,255,166,166);
		this.e2 = new Ellipse(50,150, 45,45, 255,0,0,0,0,0);
		this.e3 = new Ellipse(200,200, 30,100, 0,0,255,255,255,255);
		
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
		this.r2.paint(g);
		this.r3.paint(g);
        this.e1.paint(g);
		this.e2.paint(g);
		this.e3.paint(g);
    }
}

class Rect {
    int x, y;
	//int i,j;
    int w, h;
	//int a,l;
	int bdr, bdg, bdb;
	int bgr, bgg, bgb;

    Rect (int x, int y, int w, int h, int bdr, int bdg, int bdb, int bgr, int bgg, int bgb) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.bdr = bdr;
		this.bdg = bdg;
		this.bdb = bdb;
		this.bgr = bgr;
		this.bgg = bgg;
		this.bgb = bgb;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
		g.setColor(new Color(bdr,bdg,bdb));
        g.drawRect(this.x,this.y, this.w,this.h);
		/*
		this.i = x+1;
		this.j = y+1;
		this.l = w-1;
		this.a = h-1;
		*/
		g.setColor(new Color(bgr,bgg,bgb));
		g.fillRect(this.x+1,this.y+1, this.w-1,this.h-1);
    }
}

class Ellipse {
    int x, y;
	//int i,j;
    int w, h;
	//int a,l;
	int bdr, bdg, bdb;
	int bgr, bgg, bgb;

    Ellipse (int x, int y, int w, int h, int bdr, int bdg, int bdb, int bgr, int bgg, int bgb) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.bdr = bdr;
		this.bdg = bdg;
		this.bdb = bdb;
		this.bgr = bgr;
		this.bgg = bgg;
		this.bgb = bgb;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(bdr,bdg,bdb));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
		/*
		this.i = x+1;
		this.j = y+1;
		this.l = w-1;
		this.a = h-1;
		*/
		g.setColor(new Color(bgr,bgg,bgb));
		g2d.fill(new Ellipse2D.Double(this.x+1,this.y+1, this.w-1,this.h-1));
    }
}