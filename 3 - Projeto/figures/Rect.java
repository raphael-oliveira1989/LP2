package figures;

import java.awt.*;

public class Rect extends Figure{
    private int w, h;
	private Color bd;

    public Rect (int x, int y, int w, int h, Color bd, Color bg) {
        super(x,y,bg);
        this.w = w;
        this.h = h;
		this.bd = bd;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, x, y);
    }

    public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(bd);
        g2d.drawRect(x,y, this.w,this.h);
		g2d.setColor(bg);
		g2d.fillRect(x+1,y+1, this.w-1,this.h-1);
    }
}