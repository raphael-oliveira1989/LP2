import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class IfaceApp {
    public static void main (String[] args) {
        IfaceFrame frame = new IfaceFrame();
        frame.setVisible(true);
    }
}

class IfaceFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
	ArrayList<Button> buts = new ArrayList<Button>();
    Random rand = new Random();
	Rect r = new Rect(0,0,0,0,new Color(0,0,0,0),new Color(0,0,0,0),'r');
	Figure focus = new Ellipse(0,0,0,0,new Color(0,0,0,0),new Color(0,0,0,0),'e');
	Button focus_button = null;

    IfaceFrame () {
		buts.add(new Button(0,new Rect(0,0,0,0,Color.black,Color.black,'r')));
		buts.add(new Button(1,new Ellipse(0,0,0,0,Color.black,new Color(0,0,0,0),'e')));
		buts.add(new Button(2,new Arc(0,0,0,0,0,120,new Color(0,0,0,0),Color.black,1,'a')));
		buts.add(new Button(3,new Text("T",0,0,0,0,"Arial",10,new Color(0,0,0,0),Color.black,'t')));
		
		//janela
        this.addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        });
		
		//telcado
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
			}else if (c == 'e') {
				//cria elipse
				//Ellipse (int x, int y, int w, int h, Color bd, Color bg,char c)
                figs.add(new Ellipse(x,y, w,h,Color.black,new Color(0,0,0,0),c));
                repaint();  // outer.repaint()
            }else if (c == 'a') {
				//cria arco
				int arci = rand.nextInt(180);
				int arcf = rand.nextInt(360);
				int choice = rand.nextInt(3);
				//Arc (int x, int y, int w, int h, int arci, int arcf, Color bd, Color bg, int choice,char c)
                figs.add(new Arc(x,y,w,h,arci,arcf,new Color(0,0,0,0),Color.black,choice,c));
                repaint();  // outer.repaint()
            }else if (c == 't') {
				//cria texto
				//Text (String stg, int x, int y, int w, int h, String font, int size, Color bd, Color bg,char c)
				int size = 20;
				String stg = "hello";
                figs.add(new Text(stg,x,y,w,h,"Arial",size,new Color(0,0,0,0),Color.black,c));
                repaint();  // outer.repaint()
            }else if (c == 'c') {
				//limpa tela
                figs.clear();
				r.corbd(new Color(0,0,0,0));
                repaint();  // outer.repaint()
            }else if (c == '0') {
				//troca a cor de fundo para o padrao(na verdade esconde a cor)
				for(Figure fig: figs){
					if(focus == fig){
						fig.corbg(new Color(0,0,0,0));
						repaint();
					}
				}
            }else if (c == '1') {
				//troca a cor de fundo para vermelho
				for(Figure fig: figs){
					if(focus == fig){
						fig.corbg(Color.red);
						repaint();
					}
				}
            }else if (c == '2') {
				//troca a cor de fundo para azul
				for(Figure fig: figs){
					if(focus == fig){
						fig.corbg(Color.blue);
						repaint();
					}
				}
            }else if (c == '3') {
				//troca a cor de fundo para cinza
				for(Figure fig: figs){
					if(focus == fig){
						fig.corbg(Color.gray);
						repaint();
					}
				}
            }else if (c == '4') {
				//troca a cor de fundo para amarelo
				for(Figure fig: figs){
					if(focus == fig){
						fig.corbg(Color.yellow);
						repaint();
					}
				}
            }else if (c == '5') {
				//troca a cor de fundo para branco
				for(Figure fig: figs){
					if(focus == fig){
						fig.corbg(Color.white);
						repaint();
					}
				}
            }else if (c == '6') {
				//troca a cor de fundo para preto
				for(Figure fig: figs){
					if(focus == fig){
						fig.corbg(Color.black);
						repaint();
					}
				}
            }else if (c == '7') {
				//troca a cor de borda para verde
				for(Figure fig: figs){
					if(focus == fig){
						fig.corbd(Color.green);
						repaint();
					}
				}
            }else if (c == '8') {
				//troca a cor de borda para laranja
				for(Figure fig: figs){
					if(focus == fig){
						fig.corbd(Color.orange);
						repaint();
					}
				}
            }else if (c == '9') {
				//troca a cor de borda para preto
				for(Figure fig: figs){
					if(focus == fig){
						fig.corbd(Color.black);
						repaint();
					}
				}
            }else if (c == '+') {
				//aumenta a figura
				for(Figure fig: figs){
					if(focus == fig){
						fig.tamanho(1,1);
						if(fig.c == 't'){
							r.tamanho(3,2);
						}else{
							r.tamanho(1,1);
						}
						repaint();
					}
				}
            }else if (c == '-') {
				//diminui a figura
				for(Figure fig: figs){
					if(focus == fig){
						fig.tamanho(-1,-1);
						if(fig.c == 't'){
							r.tamanho(-3,-2);
						}else{
							r.tamanho(-1,-1);
						}
						repaint();
					}
				}
            }/*else if(c == '/'){
				//troca a selecao de figura (tab)
				//System.out.format("Elementos no vetor: ["+figs.size()+"]");
				Figure aux = new Ellipse(0,0,0,0,new Color(0,0,0,0),new Color(0,0,0,0),'e');
				r.corbd(new Color(0,0,0,0));
				focus = aux;
                for (Figure fig: figs) {
                    focus = fig;
					if (focus.c == 't'){
						r.set(focus.x-1,focus.y-20,focus.w+2,focus.h+5);
						r.corbd(Color.red);
					}else{
						r.set(focus.x-1,focus.y-1,focus.w+2,focus.h+2);
						r.corbd(Color.red);
					}
				}
				figs.remove(focus);
				figs.add(focus);
				repaint();
            }*/if(evt.getKeyCode() == 40){//baixo
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
				Figure aux = new Ellipse(0,0,0,0,new Color(0,0,0,0),new Color(0,0,0,0),'e');
				for(Figure fig: figs){
					if(focus == fig){
						aux = fig;
						r.corbd(new Color(0,0,0,0));
					}
				}
				figs.remove(focus);
				repaint();
			}/*else{
				System.out.format("char, code: ["+evt.getKeyChar()+","+evt.getKeyCode()+"]");
			}*/
        }
    });
		
		//mouse
        this.addMouseListener (new MouseAdapter() {
            public void mousePressed (MouseEvent evt) {
				Figure aux = new Ellipse(0,0,0,0,new Color(0,0,0,0),new Color(0,0,0,0),'e');
				r.corbd(new Color(0,0,0,0));
				focus = aux;
                int x = evt.getX();
                int y = evt.getY();
                for (Figure fig: figs) {
                    if (fig.clicked(x,y)) {
                        focus = fig;
						if (focus.c == 't'){
							r.set(focus.x-1,focus.y-20,focus.w+2,focus.h+5);
							r.corbd(Color.red);
						}else{
							r.set(focus.x-1,focus.y-1,focus.w+2,focus.h+2);
							r.corbd(Color.red);
						}
					}
				}
				figs.remove(focus);
				figs.add(focus);
				repaint();
            }
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
						if (fig.c == 't'){
							r.y = focus.y-20;
						}else{
							r.y = focus.y-1;
						}
						repaint();
					}
				}
			}
		});

        this.setTitle("Iterface IVisible");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setSize(350, 350);
		this.setUndecorated(false);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint (Graphics g) {
        super.paint(g);
		for (Button but: this.buts) {
            but.paint(g);
        }
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
		this.r.paint(g);
    }
}