package figures;

import java.awt.*;

public class Rect {
    private int x, y;
    private int w, h;
	private int bdr, bdg, bdb;
	private int bgr, bgg, bgb;

    public Rect (int x, int y, int w, int h, int bdr, int bdg, int bdb, int bgr, int bgg, int bgb) {
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

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(bdr,bdg,bdb));
        g2d.drawRect(this.x,this.y, this.w,this.h);
		this.x+=1;this.y+=1;
		this.w-=1;this.h-=1;
		g2d.setColor(new Color(bgr,bgg,bgb));
		g2d.fillRect(this.x,this.y, this.w,this.h);
    }
}
/*
public class Rect {
    int x, y;
    int w, h;

    public Rect (int x, int y, int w, int h) {
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
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
*/