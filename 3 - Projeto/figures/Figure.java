package figures;

import java.awt.*;

public abstract class Figure {
	public int x, y,w,h;
    public Color bg,bd,rcl;
	
    public Figure (int x, int y, int w, int h, Color bd, Color bg, Color rcl) {
        this.x = x;
        this.y = y;
		this.w = w;
		this.h = h;
        this.bd = bd;
		this.bg = bg;
		this.rcl = rcl;
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
	
	public void onfocus(){
		this.rcl=Color.red;
	}
	
	public void offfocus(){
		this.rcl=new Color(0,0,0,0);
	}
	
    public abstract void paint (Graphics g);
}