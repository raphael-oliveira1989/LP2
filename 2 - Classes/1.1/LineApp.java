import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LineApp {
	
    public static void main (String[] args) {
        Line l1 = new Line(5,5, 7,5,0.0);
        l1.print();
    }
}
class Line{
    int p1x,p1y;
	int p2x,p2y;
	double rot;
	double size;
    Line (int p1x, int p1y, int p2x, int p2y, double rot) {
        this.p1x = p1x;
        this.p1y = p1y;
        this.p2x = p2x;
        this.p2y = p2y;
		this.rot =rot; 
		this.size = Math.sqrt(Math.pow(this.p1x-this.p2x,2)+Math.pow(this.p1y-this.p2y,2));
	}
    void print () {
		if (this.size==0){
			System.out.format("Ponto na posicao (%d,%d).\n",
			this.p1x, this.p1y);
		}else{
		System.out.format("Linha de tamanho %.2f, que comeca na posicao (%d,%d), termina na posicao (%d,%d) e possui rotacao %.1f graus.\n",
            this.size, this.p1x, this.p1y, this.p2x, this.p2y, this.rot);
		}
    }
}
