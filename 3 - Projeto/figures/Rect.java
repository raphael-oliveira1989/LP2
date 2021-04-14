package figures;

import java.awt.*;

public class Rect extends Figure{
	private Color bd;

    public Rect (int x, int y, int w, int h, Color bd, Color bg, Color rcl) {
        super(x,y,w,h,bg,rcl);
		this.bd = bd;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n", w, h, x, y);
    }

    public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(rcl);
		g2d.drawRect(x-1,y-1,w+1,h+1);
		g2d.setColor(bd);
        g2d.drawRect(x,y,w,h);
		g2d.setColor(bg);
		g2d.fillRect(x+1,y+1,w-1,h-1);
    }
}