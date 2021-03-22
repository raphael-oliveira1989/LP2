package figures;

import java.awt.*;

public class Ellipse {
    private int x, y,i,j;
    private int w, h,a,l;
	private Color bg, bd;

    public Ellipse (int x, int y, int w, int h, Color bd, Color bg) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.bd = bd;
		this.bg = bg;
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(bd);
        g2d.drawOval(this.x,this.y, this.w,this.h);
		this.i = x+1;
		this.j = y+1;
		this.l = w-1;
		this.a = h-1;
		g2d.setColor(bg);
		g2d.fillOval(this.i,this.j, this.l,this.a);
    }
}
/*
public class Ellipse {
    int x, y;
    int w, h;

    public Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}
*/