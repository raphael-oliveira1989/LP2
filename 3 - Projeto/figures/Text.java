package figures;

import java.awt.*;

public class Text extends Figure{
    private String stg,font;
	private int size;
	
    public Text (String stg, int x, int y, int w, int h, String font, int size, Color bd, Color bg,char c) {
		super(x,y,w,h,bd,bg,c);
		this.stg = stg;
		this.font = font;
		this.size = size;
    }
	
	//override
	public void tamanho(int dw, int dh){
		this.w += dw;
		this.h += dh;
		this.y += (dw+dh)/2;
		this.size += (dw+dh)/2;
	}

    public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font(font, Font.BOLD, size));
		FontMetrics metrics = g.getFontMetrics();
		this.h=metrics.getHeight();
		this.w=metrics.stringWidth(stg);
		g2d.setColor(bg);
		g2d.drawString(stg,x,y);
    }
}