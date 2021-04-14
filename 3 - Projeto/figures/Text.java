package figures;

import java.awt.*;

public class Text extends Figure{
    private String stg, font;
	private int size;
	
    public Text (String stg, int x, int y, int w, int h, String font, int size, Color bg, Color rcl) {
        super(x,y,w,h,bg,rcl);
		this.stg = stg;
		this.font = font;
		this.size = size;
    }
	
	//override
	public void tamanho(int dw, int dh){
		this.size += (dw+dh)/2;
	}

    public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font(font, Font.BOLD, size));
		FontMetrics metrics = g.getFontMetrics();
		this.h=metrics.getHeight();
		this.w=metrics.stringWidth(stg);
		g2d.setColor(rcl);
		g2d.drawRect(x-1,y-1,w+1,-(h+1));
		g2d.setColor(bg);
		g2d.drawString(stg,x,y);
    }
}