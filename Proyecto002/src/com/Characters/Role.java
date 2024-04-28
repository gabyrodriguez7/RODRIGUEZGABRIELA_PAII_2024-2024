package com.Characters;

import java.awt.Graphics;

import com.Package.Drawable;
import com.Package.Move;
import com.Package.Shoot;
import com.Package.Life;

public class Role {
	
	
	public void draw(Graphics g, Drawable draw) {
		draw.Draw(g);

	}

	public void move(Move mov) {
		mov.move();
		

	}
	public void shoot(Shoot shoo){
		shoo.shoot();
	}
	public void life(Life li){
		li.life();
	}

}
