package figures;

import java.awt.*;

public abstract class Figure {
	int x, y;
    Color bg;
	
    public abstract void paint (Graphics g);
}