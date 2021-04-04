package figures;

import java.awt.*;

public class Rect extends Figure{
    private int w, h;
	private Color bd;

    public Rect (int x, int y, int w, int h, Color bd, Color bg) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.bd = bd;
		this.bg = bg;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, x, y);
    }

    public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(bd);
        g2d.drawRect(x,y, this.w,this.h);
		/*
		this.i = x+1;
		this.j = y+1;
		this.l = w-1;
		this.a = h-1;
		*/
		g2d.setColor(bg);
		g2d.fillRect(x+1,y+1, this.w-1,this.h-1);
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