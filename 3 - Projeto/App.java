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
	Rect r;
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
					//System.out.format("Figura na coordenada : ["+fig.x+","+fig.y+"]");
					//seleciona a figura com o mouse
					if((fig.x <= evt.getX() && fig.x + fig.w >= evt.getX()) && (fig.y <= evt.getY() && fig.y + fig.h >= evt.getY())){
						focus = fig;
						r = new Rect(focus.x-1,focus.y-1,focus.w+2,fig.h+2,Color.red,new Color(0,0,0,0),'r');
						figs.remove(focus);
						figs.add(focus);
					}else{
						r.corbd(new Color(0,0,0,0));
						focus = null;
					}
					repaint();
				}
			}
			
			/*public void mouseReleased(MouseEvent evt) {
				for(Figure fig: figs){;
					if(focus == fig){
						focus.offfocus();
					}
				}
				repaint();
			}*/
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent evt){
				//arrasta figura com o mouse
				//System.out.format("Mouse arrastado nas coordenadas : ["+evt.getX()+","+evt.getY()+"]");
				for(Figure fig: figs){
					if(focus == fig){
						focus.x = evt.getX()-focus.w/2;
						focus.y = evt.getY()-focus.h/2;
						r.x = focus.x-1;
						r.y = focus.y-1;
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
						char c = evt.getKeyChar();
                    if (c == 'r') {
						//cria retangulo
						//Rect (int x, int y, int w, int h, Color bd, Color bg,char c)
                        figs.add(new Rect(x,y, w,h,Color.black,new Color(0,0,0,0),c));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 'e') {
						//cria elipse
						//Ellipse (int x, int y, int w, int h, Color bd, Color bg,char c)
                        figs.add(new Ellipse(x,y, w,h,Color.black,new Color(0,0,0,0),c));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 'a') {
						//cria arco
						int arci = rand.nextInt(180);
						int arcf = rand.nextInt(360);
						int choice = rand.nextInt(3);
						//Arc (int x, int y, int w, int h, int arci, int arcf, Color bd, Color bg, int choice,char c)
                        figs.add(new Arc(x,y,w,h,arci,arcf,new Color(0,0,0,0),Color.black,choice,c));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 't') {
						//cria texto
						//Text (String stg, int x, int y, int w, int h, String font, int size, Color bd, Color bg,char c)
						int size = 20;
						String stg = "hello";
                        figs.add(new Text(stg,x,y,w,h,"Arial",size,new Color(0,0,0,0),Color.black,c));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == 'c') {
						//limpa tela
                        figs.clear();
						r.corbd(new Color(0,0,0,0));
                        repaint();  // outer.repaint()
                    }else if (evt.getKeyChar() == '0') {
						//troca a cor de fundo para o padrao(na verdade esconde a cor)
						for(Figure fig: figs){
							if(focus == fig){
								fig.corbg(new Color(0,0,0,0));
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '1') {
						//troca a cor de fundo para vermelho
						for(Figure fig: figs){
							if(focus == fig){
								fig.corbg(Color.red);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '2') {
						//troca a cor de fundo para azul
						for(Figure fig: figs){
							if(focus == fig){
								fig.corbg(Color.blue);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '3') {
						//troca a cor de fundo para cinza
						for(Figure fig: figs){
							if(focus == fig){
								fig.corbg(Color.gray);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '4') {
						//troca a cor de fundo para amarelo
						for(Figure fig: figs){
							if(focus == fig){
								fig.corbg(Color.yellow);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '5') {
						//troca a cor de fundo para branco
						for(Figure fig: figs){
							if(focus == fig){
								fig.corbg(Color.white);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '6') {
						//troca a cor de fundo para preto
						for(Figure fig: figs){
							if(focus == fig){
								fig.corbg(Color.black);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '7') {
						//troca a cor de borda para verde
						for(Figure fig: figs){
							if(focus == fig){
								fig.corbd(Color.green);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '8') {
						//troca a cor de borda para laranja
						for(Figure fig: figs){
							if(focus == fig){
								fig.corbd(Color.orange);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '9') {
						//troca a cor de borda para preto
						for(Figure fig: figs){
							if(focus == fig){
								fig.corbd(Color.black);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '+') {
						//aumenta a figura
						for(Figure fig: figs){
							if(focus == fig){
								fig.tamanho(1,1);
								r.tamanho(1,1);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '-') {
						//diminui a figura
						for(Figure fig: figs){
							if(focus == fig){
								fig.tamanho(-1,-1);
								r.tamanho(-1,-1);
								repaint();
							}
						}
                    }/*else if (evt.getKeyChar() == '//tab') {
						//troca a selecao de figura
						for(Figure fig: figs){
							focus=fig;
							focus.onfocus();
							figs.remove(focus);
							figs.add(focus);
							repaint();
						}
                    }*/else if(evt.getKeyCode() == 40){//baixo
						//move figura selecionada para baixo
						for(Figure fig: figs){
							if(focus == fig){
								fig.drag(0,1);
								r.drag(0,1);
								repaint();
							}
						}
					}else if(evt.getKeyCode() == 38){//cima
						//move figura selecionada para cima
						for(Figure fig: figs){
							if(focus == fig){
								fig.drag(0,-1);
								r.drag(0,-1);
								repaint();
							}
						}
					}else if(evt.getKeyCode() == 37){//esquerda
						//move figura selecionada para esquerda
						for(Figure fig: figs){
							if(focus == fig){
								fig.drag(-1,0);
								r.drag(-1,0);
								repaint();
							}
						}
					}else if(evt.getKeyCode() == 39){//direita
						//move figura selecionada para direita
						for(Figure fig: figs){
							if(focus == fig){
								fig.drag(1,0);
								r.drag(1,0);
								repaint();
							}
						}
					}else if(evt.getKeyCode() == 127){//delete
						//deleta figura selecionada
						for(Figure fig: figs){
							if(focus == fig){
								figs.remove(fig);
								r.corbd(new Color(0,0,0,0));
								repaint();
							}
						}
					}/*else{
						System.out.format("char, code: ["+evt.getKeyChar()+","+evt.getKeyCode()+"]");
					}*/
                }
            }
        );

        this.setTitle("Projeto");
        this.setSize(800, 600);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
		this.r.paint(g);
    }
}