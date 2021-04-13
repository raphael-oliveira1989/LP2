package figures;

import java.awt.*;

public abstract class Figure {
	public int x, y;
    public Color bg;
	
    public Figure (int x, int y, Color bg) {
        this.x = x;
        this.y = y;
        this.bg = bg;
    }

    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
	
	public void corbg(Color bg){
		this.bg=bg;
	}
	
	public abstract void altera(int dw, int dh);
	
    public abstract void paint (Graphics g);
}