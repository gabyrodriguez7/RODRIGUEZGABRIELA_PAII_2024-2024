package com.Characters;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

import com.Main.Window;
import com.Package.Drawable;
import com.Package.Life;
import com.Package.Move;
import com.Package.Shoot;

public class Villain implements Drawable, Life, Move, Shoot {
	static int x;
	static int y;
	private float velocidadY = 1;
	private ArrayList<Bullet> bullets;
	static int score;
	private Random random;
	private boolean gameOver;
	private Window mainWindow;
	private Hero hero;
	private boolean gameEnded = false;

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Villain(Window mainWindow, Hero hero) {
		this.mainWindow = mainWindow;
		this.hero = hero;
		initialize();
	}

	public Villain() {
		initialize();
	}

	private void initialize() {
		bullets = new ArrayList<>();
		random = new Random();
		gameOver = false;
		generateRandomPosition();
	}

	public void generateRandomPosition() {
		x = 10 + random.nextInt(770);
		y = (int) (0 + velocidadY);
	}

	@Override
	public void Draw(Graphics g) {
		if (gameOver) {
			return;
		}
		g.setColor(Color.GREEN);
		int[] vx2 = { x, x + 30, x + 30, x + 15, x };
		int[] vy2 = { y, y, y + 40, y + 25, y + 40 };
		g.fillPolygon(vx2, vy2, 5);

		for (Bullet bullet : bullets) {
			bullet.Draw(g);
		}
	}

	@Override
	public void move() {

		if (gameOver) {

			return;
		}

		y += velocidadY;

		if (y >= 405 || y <= 0) {
			gameOver = true;
			showGameOverMessage();
		}

		for (Bullet bullet : bullets) {
			bullet.move();
		}

	}

	@Override
	public void shoot() {
		if (Math.random() < 0.01) {
			bullets.add(new Bullet(x, y, false));
		}
	}

//////////////////////////////////////////////////
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
					showGameOverMessage();

				}
			}
		}

	}

	@Override
	public void life() {
		checkBulletCollision();
	}

	public void showGameOverMessage() {
		JOptionPane.showMessageDialog(mainWindow,
				"Game Over \nPerdiste \nTu vida es: " + hero.getVida() + "\nSu score es: " + getScore());
		gameEnded = true;
		mainWindow.dispose();
	}

	public void plusScore() {
		score += 100; // Reducir la vida del héroe en 10

		if (score < 0) {
			score = 0; // Asegurarse de que la vida nunca sea menor que cero
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}