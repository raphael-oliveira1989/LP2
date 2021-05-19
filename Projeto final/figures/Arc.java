package figures;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;
import java.awt.geom.Arc2D.Float;


public class Arc extends Figure{
	private int arci, arcf;

    public Arc (int x, int y, int w, int h, int arci, int arcf, Color bd, Color bg,char c) {
        super(x,y,w,h,bd,bg,c);
		this.arci = arci;
		this.arcf = arcf;
    }
	
	public void set(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void print () {
        System.out.format("Arco de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, x, y);
    }

    public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(bg);
		g2d.draw(new Arc2D.Double(x, y, w,h, arci, arcf, Arc2D.OPEN));
    }
}