package modelo_package;

import java.awt.Color;
import java.awt.Graphics;

public class Hero extends Role implements Drawable, Movable {


     
	public Hero( ) {
		super();
		super.setCord_x(new int []{400, 430, 370 });
    	super.setCord_y(new int []{ 540, 600, 600 });
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillPolygon(getCord_x(), getCord_y(), 3);
	}

	@Override
	public void moveLeft(int variable) {
		for (int i = 0; i < getCord_x().length; i++) {
			getCord_x()[i] = getCord_x()[i] - variable;

		}

	}

	@Override
	public void moveRight(int variable) {
		for (int i = 0; i < getCord_x().length; i++) {
			getCord_x()[i] = getCord_x()[i] + variable;

		}
	}

	

	@Override
	public void moveDown(int variable, Role role) {
		// TODO Auto-generated method stub

	}


	@Override
	public void draw(Graphics g, Role role,Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp(int variable, Role role) {
		// TODO Auto-generated method stub
		
	}

}
