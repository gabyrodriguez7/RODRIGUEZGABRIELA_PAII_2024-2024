package modelo_package;

import java.awt.Color;
import java.awt.Graphics;



public class Bullet implements Drawable, Movable {

	private int x;
    private int y;
    private boolean isHeroBullet;
    
    public Bullet(int x, int y, boolean isHeroBullet) {
        this.x = x;
        this.y = y;
        this.isHeroBullet = isHeroBullet;
    }
	@Override
	public void draw(Graphics g) {
		 g.setColor(Color.WHITE);
	        int bulletY = isHeroBullet ? y - 10 : y + 10; // Desplazamiento hacia arriba si es del héroe, hacia abajo si no lo es
	        g.fillOval(x, bulletY, 15, 10);
		
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
	public void moveUp(int speed) {
	
            y -= speed; // Mover la bala hacia arriba si es del héroe
       
		
	}

	@Override
	public void moveDown(int speed) {
             y += speed; // Mover la bala hacia abajo si es del villano
	 
	}
	 public boolean isHeroBullet() {
	        return isHeroBullet;
	    }
	
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


	
	
	
	
	
	

}
