package contolador_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modelo_package.Bullet;
import modelo_package.Hero;
import modelo_package.Villain;
import modelo_package.Line;

public class Container {

	int SCREEN_WIDTH = 600;
	int SCREEN_HEIGHT = 200;
	private Hero hero = new Hero();

	// private Villain villain = new Villain();
	List<Villain> villains = new ArrayList();
	List<Bullet> bull = new ArrayList();
	List<Bullet> bullV = new ArrayList();
	private Line line = new Line();
	private Random random = new Random();

	public Container() {
		villains.add(new Villain(random.nextInt(SCREEN_WIDTH) + 10, random.nextInt(SCREEN_HEIGHT)));
		villains.add(new Villain(random.nextInt(SCREEN_WIDTH) + 10, random.nextInt(SCREEN_HEIGHT)));
		villains.add(new Villain(random.nextInt(SCREEN_WIDTH) + 10, random.nextInt(SCREEN_HEIGHT)));
		villains.add(new Villain(random.nextInt(SCREEN_WIDTH) + 10, random.nextInt(SCREEN_HEIGHT)));
		villains.add(new Villain(random.nextInt(SCREEN_WIDTH) + 10, random.nextInt(SCREEN_HEIGHT)));
	}

	public void draws(Graphics g) {
		hero.draw(g);
		for (int i = 0; i < villains.size(); i++) {
			villains.get(i).draw(g);

		}
		line.draw(g);

	}

	public void moveLeft(int variable) {
		hero.moveLeft(variable);
	}

	public void moveRight(int variable) {
		hero.moveRight(variable);
	}

	public void moveUp(int variable) {
		for (int i = 0; i < bull.size(); i++) {
			bull.get(i).moveUp(variable, hero);

		}

	}

	public void moveDown(int variable) {
		for (int i = 0; i < villains.size(); i++) {
			villains.get(i).moveDown(variable, villains.get(i));

		}
	}

	public void drawShoot(Graphics g) {
		for (int i = 0; i < bull.size(); i++) {
			bull.get(i).draw(g, hero, Color.WHITE);
		}

	}

	public void drawShootV(Graphics g) {
		for (int i = 0; i < bullV.size(); i++) {

			for (int j = 0; j < villains.size(); j++) {
				bullV.get(i).draw(g, villains.get(j), Color.GREEN);
			}

		}

	}

	public void moveDownVillain(int variable) {
		for (int i = 0; i < bullV.size(); i++) {

			for (int j = 0; j < villains.size(); j++) {
				bullV.get(i).moveDown(variable, villains.get(j));
			}

		}

	}

	public void addShoot() {
		bull.add(new Bullet(hero));
	}

	public void addShootV() {

		for (int i = 0; i < villains.size(); i++) {
			bullV.add(new Bullet(villains.get(i)));
		}

	}

}
