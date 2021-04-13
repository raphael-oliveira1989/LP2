package figures;

import java.awt.*;

public class Text extends Figure{
    private String stg, font;
	private int size;
	
    public Text (String stg, int x, int y, String font, int size, Color bg) {
        super(x,y,bg);
		this.stg = stg;
		this.font = font;
		this.size = size;
    }
	
	public void tamanho(int dw, int dh){
		this.size += dw+dh;
	}

    public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font(font, Font.BOLD, size));
        g2d.setColor(bg);
		g2d.drawString(stg,x,y);
    }
}