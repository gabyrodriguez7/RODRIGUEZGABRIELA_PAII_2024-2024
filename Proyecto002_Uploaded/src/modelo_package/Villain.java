package modelo_package;

import java.awt.Color;
import java.awt.Graphics;

public class Villain extends Role implements Drawable, Movable {

	public Villain(int randomX, int randomY) {
		super();
		super.setCord_x(new int[] { randomX, randomX + 100, randomX + 100, randomX + 50, randomX });
		super.setCord_y(new int[] { randomY, randomY, randomY + 50, randomY + 25, randomY + 50 });

	}

	@Override
	public void draw(Graphics g) {

		g.setColor(Color.green);
		g.fillPolygon(getCord_x(), getCord_y(), 5);

	}

	@Override
	public void moveLeft(int variable) {

	}

	@Override
	public void moveRight(int variable) {

	}

	@Override
	public void moveDown(int variable, Role role) {
		for (int i = 0; i < getCord_y().length; i++) {
			getCord_y()[i] = getCord_y()[i] + variable;

		}

	}

	@Override
	public void draw(Graphics g, Role role, Color color) {

	}

	@Override
	public void moveUp(int variable, Role role) {
		// TODO Auto-generated method stub

	}

}
