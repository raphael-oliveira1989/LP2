package figures;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;
import java.awt.geom.Arc2D.Float;


public class Arc extends Figure{
	public int arci, arcf;
	public int choice;

    public Arc (int x, int y, int w, int h, int arci, int arcf, Color bd, Color bg, int choice,char c) {
        super(x,y,w,h,bd,bg,c);
		this.arci = arci;
		this.arcf = arcf;
		this.choice = choice;
    }
	
	public void print () {
        System.out.format("Arco de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, x, y);
    }

    public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(bg);
		if(this.choice==1){
			g2d.draw(new Arc2D.Double(x, y, w,h, arci, arcf, Arc2D.OPEN));
		}else if(this.choice==2){
			g2d.fill(new Arc2D.Double(x, y, w,h, arci, arcf, Arc2D.PIE));
		}else if(this.choice==3){
			g2d.fill(new Arc2D.Double(x, y, w,h, arci, arcf, Arc2D.CHORD));
		}
    }
}