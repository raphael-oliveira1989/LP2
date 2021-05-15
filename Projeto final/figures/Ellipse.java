package figures;

import java.awt.*;

public class Ellipse extends Figure{

    public Ellipse (int x, int y, int w, int h, Color bd, Color bg,char c) {
		super(x,y,w,h,bd,bg,c);
    }
	
	public void set(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, x, y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(bd);
        g2d.drawOval(x,y, this.w,this.h);
		g2d.setColor(bg);
		g2d.fillOval(x+1,y+1, this.w-1,this.h-1);
    }
}