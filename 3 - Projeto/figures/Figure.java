package figures;

import java.awt.*;

public abstract class Figure {
	public int x, y,w,h;
    public Color bg,bd;
	public char c;
	
    public Figure (int x, int y, int w, int h, Color bd, Color bg,char c) {
        this.x = x;
        this.y = y;
		this.w = w;
		this.h = h;
        this.bd = bd;
		this.bg = bg;
		this.c = c;
    }

    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
	
	public void tamanho(int dw, int dh){
		this.w += dw;
		this.h += dh;
	}
	
	public void corbg(Color bg){
		this.bg=bg;
	}
	
	public void corbd(Color bd){
		this.bd=bd;
	}
	
    public abstract void paint (Graphics g);
}