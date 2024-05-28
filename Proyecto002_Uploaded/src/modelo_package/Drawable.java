package modelo_package;

import java.awt.Color;
import java.awt.Graphics;

public interface Drawable {
	
	void draw(Graphics g);

	void draw(Graphics g, Role role, Color color);

}
