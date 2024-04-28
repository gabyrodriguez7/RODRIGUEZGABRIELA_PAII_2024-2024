package com.Characters;

import java.awt.Color;
import java.awt.Graphics;

import com.Package.Drawable;
import com.Package.Move;

public class Bullet implements Drawable, Move  {
	private int x;
    private int y;
    private final int speed = 9; // Velocidad de la bala
    private boolean isHeroBullet;
    
  

    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Bullet(int x, int y, boolean isHeroBullet) {
        this.x = x;
        this.y = y;
        this.isHeroBullet = isHeroBullet;
    }
	 public boolean isHeroBullet() {
	        return isHeroBullet;
	    }

    @Override
    public void move() {
    	  if (isHeroBullet) {
              y -= speed; // Mover la bala hacia arriba si es del héroe
          } else {
              y += speed; // Mover la bala hacia abajo si no es del héroe
          }
    }


	@Override
	public void Draw(Graphics g) {
	    g.setColor(Color.WHITE);
        // Dibujar la bala un poco por encima o por debajo de la posición y del héroe, dependiendo de si es del héroe o no
        int bulletY = isHeroBullet ? y - 10 : y + 10; // Desplazamiento hacia arriba si es del héroe, hacia abajo si no lo es
        g.fillOval(x, bulletY, 15, 10);
	        
	}
}
