import java.awt.*;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;


class App {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
		//new Mover().start();
    }
}
/*
class Mover extends Thread{
	public void run(){
		while(true){
			if(mousepressed){
				try{sleep(10);}catch(Exception erro){}
				Point ponto = getMousePosition();
				frame.setBounds(ponto.x,ponto.y,51,51);
			}
		}
	}
}
*/
class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
	boolean mousepressed = false;
    Random rand = new Random();
	Figure focus = null;


    ListFrame () {
		//janela
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
		
		//mouse
		this.addMouseListener(new MouseAdapter(){
			/*
			public void mousePressed(MouseEvent evt){
				mousepressed = true;
			}
			public void mouseReleased(MouseEvent evt){
				mousepressed = false;
			}
			*/
			public void mouseClicked(MouseEvent evt){
				focus = null;
				for(Figure fig: figs){
					//System.out.format("Figura na coordenada : ["+fig.x+","+fig.y+"]");
					//seleciona a figura com o mouse
					if(evt.getX() == fig.x &&  evt.getY() == fig.y){
						focus = fig;
						repaint();
					}
				}
				 //System.out.format("Mouse clicado na coordenada : ["+evt.getX()+","+evt.getY()+"]");
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent evt){
				//System.out.format("Mouse arrastado nas coordenadas : ["+evt.getX()+","+evt.getY()+"]");
				//arrasta figura com o mouse
				for(Figure fig: figs){
					if(focus == fig){
						fig.drag(fig.x+evt.getX(),fig.y+evt.getY());
						repaint();
					}
				}
			}
		});
		
		//teclado
        this.addKeyListener (new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
						int x = 100;
                        int y = 100;
                        int w = 50;
                        int h = 50;
						int bgr = rand.nextInt(255);
						int bgg = rand.nextInt(255);
						int bgb = rand.nextInt(255);
						int bdr = rand.nextInt(255);
						int bdg = rand.nextInt(255);
						int bdb = rand.nextInt(255);
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x,y, w,h,new Color(bgr,bgg,bgb),new Color(bdr,bdg,bdb)));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h,new Color(bgr,bgg,bgb),new Color(bdr,bdg,bdb)));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 'a') {
						int arci = rand.nextInt(180);
						int arcf = rand.nextInt(360);
						int choice = rand.nextInt(3);
                        figs.add(new Arc(x,y,w,h,arci,arcf,new Color(bgr,bgg,bgb),choice));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 't') {
						//Text (String stg, int x, int y, String font, int size, Color bg) 
						int size = rand.nextInt(50);
                        figs.add(new Text("hello",x,y,"Arial",size,new Color(bgr,bgg,bgb)));
                        repaint();  // outer.repaint()
                    }else if(evt.getKeyCode() == 40){//baixo
						//move figura para baixo
					}else if(evt.getKeyCode() == 38){//cima
						//move figura para cima
					}else if(evt.getKeyCode() == 37){//esquerda
						//move figura para esquerda
					}else if(evt.getKeyCode() == 39){//direita
						//move figura para direita
					}else if(evt.getKeyCode() == 127){//delete
						//deleta figura
					}else if(evt.getKeyCode() == 16){//shift
						//troca figura
					}
                }
            }
        );

        this.setTitle("Projeto");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
