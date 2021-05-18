import java.awt.*;

import ivisible.IVisible;
import figures.Figure;

public class Button implements IVisible{
	public int idx, x,y,w,h;
	public Color bg = Color.lightGray;;
	private Figure fig;
	private int aux;
	
	public Button(int idx, Figure fig){
		this.idx = idx;
		this.fig = fig;
		this.x=20;
		this.y=45;
		this.w=40;
		this.h=40;
	}
	
	public boolean clicked(int x, int y){
        return (this.x<=x && x<=this.x+this.w && this.aux<=y && y<=this.aux+this.h);
	}
	
	public int get(){
		return idx;
	}
	public void set(Color bg){
		this.bg = bg;
	}

	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		aux = y;
		if(idx==0){
			g2d.drawRect(x,aux,w,h);
			g2d.setColor(bg);
			g2d.fillRect(x+1,aux+1,w-1,w-1);
			this.fig.set(x+5,aux+5,w-10,h-10);
		}else if(idx==1){
			aux+=40;
			g2d.drawRect(x,aux,w,h);
			g2d.setColor(bg);
			g2d.fillRect(x+1,aux+1,w-1,w-1);
			this.fig.set(x+5,aux+5,w-10,h-10);
		}else if(idx==2){
			aux+=80;
			g2d.drawRect(x,aux,w,h);
			g2d.setColor(bg);
			g2d.fillRect(x+1,aux+1,w-1,w-1);
			this.fig.set(x+7,aux+7,w-10,h-10);
		}else if(idx==3){
			aux+=120;
			g2d.drawRect(x,aux,w,h);
			g2d.setColor(bg);
			g2d.fillRect(x+1,aux+1,w-1,w-1);
			this.fig.set(x+13,aux+29,w-10,h-10);
		}
		this.fig.paint(g);
	}
}