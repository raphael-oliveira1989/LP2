import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;


class App {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
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
			
			public void mousePressed(MouseEvent evt){
				focus = null;
				//System.out.format("Mouse clicado na coordenada : ["+evt.getX()+","+evt.getY()+"]");
				for(Figure fig: figs){
					//System.out.format("Figura na coordenada : ["+fig.x+","+fig.y+"]);
					//seleciona a figura com o mouse
					if((fig.x <= evt.getX() && fig.x + 50 >= evt.getX()) && (fig.y <= evt.getY() && fig.y + 50 >= evt.getY())){
						//System.out.format("entrou aqui");
						focus = fig;
						figs.remove(focus);
						figs.add(focus);
						repaint();
					}
				}
			}
			
			/*
			public void mouseClicked(MouseEvent evt){
				focus = null;
				//System.out.format("Mouse clicado na coordenada : ["+evt.getX()+","+evt.getY()+"]");
				for(Figure fig: figs){
					//System.out.format("Figura na coordenada : ["+fig.x+","+fig.y+"]");
					//seleciona a figura com o mouse
					if((fig.x <= evt.getX() && fig.x + 50 >= evt.getX()) && (fig.y <= evt.getY() && fig.y + 50 >= evt.getY())){
						//System.out.format("entrou aqui");
						focus = fig;
						figs.remove(focus);
						figs.add(focus);
						repaint();
					}
				}
			}
			*/
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent evt){
				//arrasta figura com o mouse
				//System.out.format("Mouse arrastado nas coordenadas : ["+evt.getX()+","+evt.getY()+"]");
				for(Figure fig: figs){
					if(focus == fig){
						focus.x = evt.getX()-50/2;
						focus.y = evt.getY()-50/2;
						repaint();
					}
				}
			}
		});
	
		
		//teclado
        this.addKeyListener (new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
						Point ponto = getMousePosition();
						int x = ponto.x;
                        int y = ponto.y;
                        int w = 50;
                        int h = 50;
                    if (evt.getKeyChar() == 'r') {
						//cria retangulo
						//Rect (int x, int y, int w, int h, Color bd, Color bg)
                        figs.add(new Rect(x,y, w,h,Color.black,Color.white));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 'e') {
						//cria elipse
						//Ellipse (int x, int y, int w, int h, Color bd, Color bg)
                        figs.add(new Ellipse(x,y, w,h,Color.black,Color.white));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 'a') {
						//cria arco
						int arci = rand.nextInt(180);
						int arcf = rand.nextInt(360);
						int choice = rand.nextInt(3);
						//Arc (int x, int y, int w, int h, int arci, int arcf, Color bg, int choice)
                        figs.add(new Arc(x,y,w,h,arci,arcf,Color.black,choice));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 't') {
						//cria texto
						//Text (String stg, int x, int y, String font, int size, Color bg) 
						int size = 20;
                        figs.add(new Text("hello",x,y,"Arial",size,Color.black));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == '1') {
						//troca a cor de fundo para vermelho
						for(Figure fig: figs){
							if(focus == fig){
								focus.corbg(Color.red);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '2') {
						//troca a cor de fundo para azul
						for(Figure fig: figs){
							if(focus == fig){
								focus.corbg(Color.blue);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '3') {
						//troca a cor de fundo para preto
						for(Figure fig: figs){
							if(focus == fig){
								focus.corbg(Color.gray);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '4') {
						//troca a cor de fundo para verde
						for(Figure fig: figs){
							if(focus == fig){
								focus.corbg(Color.green);
								repaint();
							}
						}
                    }else if(evt.getKeyCode() == 40){//baixo
						//move figura selecionada para baixo
						for(Figure fig: figs){
							if(focus == fig){
								focus.drag(0,1);
								repaint();
							}
						}
					}else if(evt.getKeyCode() == 38){//cima
						//move figura selecionada para cima
						for(Figure fig: figs){
							if(focus == fig){
								focus.drag(0,-1);
								repaint();
							}
						}
					}else if(evt.getKeyCode() == 37){//esquerda
						//move figura selecionada para esquerda
						for(Figure fig: figs){
							if(focus == fig){
								focus.drag(-1,0);
								repaint();
							}
						}
					}else if(evt.getKeyCode() == 39){//direita
						//move figura selecionada para direita
						for(Figure fig: figs){
							if(focus == fig){
								focus.drag(1,0);
								repaint();
							}
						}
					}else if(evt.getKeyCode() == 127){//delete
						//deleta figura selecionada
						for(Figure fig: figs){
							if(focus == fig){
								figs.remove(focus);
								repaint();
							}
						}
					}else if(evt.getKeyCode() == 16){//shift
						//troca a selecao de figura
					}/*else{
						System.out.format("char, code: ["+evt.getKeyChar()+","+evt.getKeyCode()+"]");
					}*/
                }
            }
        );

        this.setTitle("Projeto");
        this.setSize(800, 600);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}