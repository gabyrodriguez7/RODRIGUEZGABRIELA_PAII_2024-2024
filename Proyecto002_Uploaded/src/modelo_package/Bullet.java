package modelo_package;

import java.awt.Color;
import java.awt.Graphics;


public class Bullet  implements Drawable, Movable {
	
   int x ;
   int y;
   
	public Bullet(Role role) {
	x = role.getCord_x()[0];
	y =  role.getCord_y()[0];
	}
	@Override
	public void draw(Graphics g, Role role, Color color) {
		g.setColor(color);
		g.fillOval(x,y, 10, 10);
	
	}

	@Override
	public void moveLeft(int variable) {

	}

	@Override
	public void moveRight(int variable) {
	

	}


	@Override
	public void moveDown(int variable, Role role) {
		y+=variable;
	}

	@Override
	public void draw(Graphics g) {

	}

	@Override
	public void moveUp(int variable, Role role) {
		y-=variable;
			
		
		
	}
}
