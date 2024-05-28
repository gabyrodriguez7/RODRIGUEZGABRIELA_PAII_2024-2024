package modelo_package;

import java.awt.Color;
import java.awt.Graphics;

public class Line implements Drawable {

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawLine(0, 396, 800,396);
	}

	@Override
	public void draw(Graphics g, Role role, Color color) {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
