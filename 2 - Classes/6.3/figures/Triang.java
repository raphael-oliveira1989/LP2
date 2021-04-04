package figures;

import java.awt.*;

public class Triang extends Figure{
    private int x2,x3;
	private int y2,y3;
	private Color bg;

    public Triang (int x1,int x2,int x3,int y1,int y2,int y3, Color bg) {
        this.x = x1;
		this.x2 = x2;
		this.x3 = x3;
        this.y = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.bg = bg;
    }

    public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(bg);
		g2d.fillPolygon(new int[] {x, this.x2, this.x3}, new int[] {y, this.y2, this.y3}, 3);
		/*
		g2d.setColor(bg);
		g2d.fillPolygon(new int[] {this.x1+1, this.x2+1, this.x3+1}, new int[] {this.y1+1, this.y2+1, this.y3+1}, 3);
		*/
	}
}