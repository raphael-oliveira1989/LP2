package figures;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;
import java.awt.geom.Arc2D.Float;


public class Arc{
    private int x, y;
    private int w, h;
	private int arci, arcf;
	private int bgr, bgg, bgb;

    public Arc (int x, int y, int w, int h, int arci, int arcf, int bgr, int bgg, int bgb) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.arci = arci;
		this.arcf = arcf;
		this.bgr = bgr;
		this.bgg = bgg;
		this.bgb = bgb;
    }

    public void paint_o (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(new Color(bgr,bgg,bgb));
        g2d.draw(new Arc2D.Double(x, y, w,h, arci, arcf, Arc2D.OPEN));
    }
	
	public void paint_p (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(new Color(bgr,bgg,bgb));
        g2d.fill(new Arc2D.Double(x, y, w,h, arci, arcf, Arc2D.PIE));
    }
	
	public void paint_c (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(new Color(bgr,bgg,bgb));
        g2d.fill(new Arc2D.Double(x, y, w,h, arci, arcf, Arc2D.CHORD));
    }
}