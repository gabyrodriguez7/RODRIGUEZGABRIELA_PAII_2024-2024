package modelo_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Hero implements Drawable, Movable, shootable, Livable {

	int[] vy1 = { 540, 600, 600 };
	static private int x = 400; // Posición X del héroe
	static private int y = 590; // Posición Y del héroe
	static int vida = 100;
	private Villain villain;
	private ArrayList<Bullet> bullets;

	public static int getVida() {
		return vida;
	}
	public void setVillain(Villain villain) {
        this.villain = villain;
        bullets = new ArrayList<>();
    }

	public Hero(Villain villain) {

		bullets = new ArrayList<>();

		this.villain = villain;
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(Color.white);
		int[] vx1 = { x, x + 40, x - 40 };
		int[] vy1 = { 520, 600, 600 }; // Coordenadas verticales constantes
		g.fillPolygon(vx1, vy1, 3);

		for (Bullet bullet : bullets) {
			bullet.draw(g);
		}

	}

	@Override
	public void moveLeft(int variable) {

		x -= variable;

	}

	@Override
	public void moveRight(int variable) {
		
		x += variable;

	}

	@Override
	public void moveUp(int variable) {

	}

	@Override
	public void moveDown(int variable) {

	}

	@Override
	public void shoot() {
		if (Math.random() < 0.02) { // Controla la frecuencia de los disparos
			bullets.add(new Bullet(x, y, true)); // Usar la posición Y del héroe

		}
		Iterator<Bullet> iterator = bullets.iterator();
		while (iterator.hasNext()) {
			Bullet bullet = iterator.next();
			bullet.moveUp(10);
		}

	}
	public void checkBulletCollision() {
        Iterator<Bullet> bulletIterator = bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            int bulletX = bullet.getX();
            int bulletY = bullet.getY();

            // Calcular la distancia entre la bala y el villano
            double distance = Math.sqrt(Math.pow(bulletX - villain.getX(), 2) + Math.pow(bulletY - villain.getY(), 2));
            if (distance <= 30) { // Radio de colisión del villano
                bulletIterator.remove(); // Eliminar la bala
                villain.setScore(villain.getScore() + 100); // Aumentar la puntuación del héroe
                villain.generateRandomPosition(); // Generar una nueva posición para el villano
                
            }
        }
    }
	 public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
		public void reduceLife() {
	        vida -= 10; // Reducir la vida del héroe en 10
	       
	        if (vida < 0) {
	            vida = 0; // Asegurarse de que la vida nunca sea menor que cero
	        }
	    }

		@Override
		public void live() {
			checkBulletCollision();
			
		}

}
