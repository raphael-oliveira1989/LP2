import java.awt.*;

import ivisible.IVisible;
import figures.Figure;

public class Button implements IVisible{
	public int idx;
	private Figure fig;
	public Color bg = Color.lightGray;
	
	public Button(int idx, Figure fig){
		this.idx = idx;
		this.fig = fig;
	}
	
	public boolean clicked(int x, int y){
        //return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
		return false;
	}
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		/*boolean focused = false;
		if (focused){
			
		}else{
		}
		*/
		g2d.setColor(Color.black);
        g2d.drawRect(20,45,40,40);
		g2d.setColor(bg);
		g2d.fillRect(21,46,39,39);
		g2d.setColor(Color.black);
		g2d.drawRect(20,86,40,40);
		g2d.setColor(bg);
		g2d.fillRect(21,87,39,39);
		g2d.setColor(Color.black);
		g2d.drawRect(20,126,40,40);
		g2d.setColor(bg);
		g2d.fillRect(21,127,39,39);
		g2d.setColor(Color.black);
		g2d.drawRect(20,166,40,40);
		g2d.setColor(bg);
		g2d.fillRect(21,167,39,39);
		/*
		if (this.idx == 0){
			this.fig.set(25,50,30,30);
		}
		if (this.idx == 1){
			this.fig.set(25,90,30,30);
		}
		if (this.idx == 2){
			this.fig.set(25,130,30,30);
		}
		if (this.idx == 3){
			this.fig.set(25,50,30,30);
		}
		*/
		this.fig.paint(g);
	}
}