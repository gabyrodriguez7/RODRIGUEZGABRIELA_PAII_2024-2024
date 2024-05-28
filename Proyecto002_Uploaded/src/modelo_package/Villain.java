package modelo_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import vista_package.GameOver;

public class Villain implements Drawable, Movable, shootable, Livable {

	static int x;
	static int y;
	private Random random;
	private boolean gameOver;
	static int score;
	private Hero hero;
	private ArrayList<Bullet> bullets;

	public Villain(Hero hero) {
		bullets = new ArrayList<>();
		random = new Random();
		generateRandomPosition();
		this.hero = hero;
	}

	public int getScore() {
		return score;
	}

	public void generateRandomPosition() {
		x = 10 + random.nextInt(770);
		y = (int) (0 + 2);
	}

	@Override
	public void draw(Graphics g) {
		if (gameOver) {
			return;
		}
		g.setColor(Color.GREEN);
		int[] vx2 = { x, x + 40, x + 40, x + 20, x };
		int[] vy2 = { y, y, y + 50, y + 30, y + 50 };
		g.fillPolygon(vx2, vy2, 5);

		for (Bullet bullet : bullets) {
			bullet.draw(g);
		}

	}

	@Override
	public void moveLeft(int variable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveRight(int variable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveUp(int variable) {

	}

	@Override
	public void moveDown(int variable) {
		if (gameOver) {

			return;
		}

		y += variable;

		if (y >= 405 || y <= 0) {
			gameOver = true;
			new GameOver().setVisible(true);
			

		}

		for (Bullet bullet : bullets) {
			bullet.moveDown(10);
		}

	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}

	@Override
	public void shoot() {
		if (Math.random() < 0.01) {
			bullets.add(new Bullet(x, y, false));
		}

	}

	public void checkBulletCollision() {
		Iterator<Bullet> bulletIterator = bullets.iterator();
		while (bulletIterator.hasNext()) {
			Bullet bullet = bulletIterator.next();
			int bulletX = bullet.getX();
			int bulletY = bullet.getY();

			// Calcular la distancia entre la bala y el héroe
			double distance = Math.sqrt(Math.pow(bulletX - hero.getX(), 2) + Math.pow(bulletY - hero.getY(), 2));
			if (distance <= 30) { // Radio de colisión del héroe
				hero.reduceLife(); // Reducir la vida del héroe
				bulletIterator.remove(); // Eliminar la bala
				if (hero.getVida() == 0) {

					if (hero.getVida() == 0) {
						new vista_package.GameOver(); // Abre la ventana de Game Over
					}
				}
			}
		}

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void plusScore() {
		score += 100; // Reducir la vida del héroe en 10

		if (score < 0) {
			score = 0; // Asegurarse de que la vida nunca sea menor que cero
		}
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public void live() {
		checkBulletCollision();
	}
}
