package com.Characters;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;



import com.Main.Window;
import com.Package.Drawable;
import com.Package.Life;
import com.Package.Move;
import com.Package.Shoot;

public class Hero implements Drawable, Life, Move, Shoot, KeyListener {

    private int x; // Posición X del héroe
    private int y; // Posición Y del héroe
    static int vida = 100;
    private Villain villain;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private Window window; // Instancia de la clase Window
    
    public static int getVida() {
		return vida;
	}

	public static void setVida(int vida) {
		Hero.vida = vida;
	}
	private float velocidad = 5f; // Velocidad de movimiento
    private ArrayList<Bullet> bullets;
    public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}
	

    public void setWindow(Window window) {
        this.window = window;
       
    }
    public void setVillain(Villain villain) {
        this.villain = villain;
    }
    public Hero(Window window, Villain villain) {
        x = 400;
        y = 599;
        bullets = new ArrayList<>();
        setWindow(window);
        this.villain = villain;
    }
    

    @Override
    public void Draw(Graphics g) {
        g.setColor(Color.WHITE);
        // Dibujar el héroe en la posición x
        int[] vx1 = { x, x + 30, x - 30 };
        int[] vy1 = { 540, 600, 600 }; // Coordenadas verticales constantes
        g.fillPolygon(vx1, vy1, 3);
        for (Bullet bullet : bullets) {
            bullet.Draw(g);
        }
    }

    @Override
    public void shoot() {
    	 if (Math.random() < 0.03) { // Controla la frecuencia de los disparos
    	        int bulletY = 540; // Ajustar la posición Y de la bala para que aparezca más arriba
    	        bullets.add(new Bullet(x, bulletY, true)); // Usar la posición ajustada Y del héroe
    	    }
    }

    public void move() {
        if (movingLeft) {
            moveLeft();
        } else if (movingRight) {
            moveRight();
        }

        // Crear un iterador para recorrer la lista de balas
        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            bullet.move();
        }

        
    }

    public void moveLeft() {
        x -= velocidad;
    }

    public void moveRight() {
        x += velocidad;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            movingLeft = true;
        } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            movingRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            movingLeft = false;
        } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            movingRight = false;
        }
    }

    public void reduceLife() {
        vida -= 10; // Reducir la vida del héroe en 10
       
        if (vida < 0) {
            vida = 0; // Asegurarse de que la vida nunca sea menor que cero
        }
    }

    @Override
    public void life() {
    	checkBulletCollision();
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

	
	

}