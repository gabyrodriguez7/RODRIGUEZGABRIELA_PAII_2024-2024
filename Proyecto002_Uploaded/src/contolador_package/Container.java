package contolador_package;

import java.awt.Graphics;

import modelo_package.Hero;
import modelo_package.Villain;
import modelo_package.Line;

public class Container {

	private Hero hero;
	private Villain villain;
	private Line line;

	public Container() {
		hero = new Hero(villain);
		villain = new Villain(hero);
		hero.setVillain(villain);
		line = new Line();

	}

	public void draws(Graphics g) {
		hero.draw(g);
		villain.draw(g);
		line.draw(g);

	}

	public void moveLeft(int variable) {
		hero.moveLeft(variable);
	}

	public void moveRight(int variable) {
		hero.moveRight(variable);
	}

	public void moveDown(int variable) {
		villain.moveDown(variable);
	}

	public void shoot() {
		villain.shoot();
		hero.shoot();
	}

	public int live() {
		hero.live();
		villain.live();

		return hero.getVida();

	}

	public int score() {

		return villain.getScore();

	}

}
