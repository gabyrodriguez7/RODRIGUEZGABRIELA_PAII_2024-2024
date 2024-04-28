package com.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import javax.swing.Timer;

import com.Characters.Hero;
import com.Characters.Role;
import com.Characters.Villain;

public class Window extends JFrame {

	public int vida;
	public Role hero;
	public Role villain;
	private List<Villain> villains;
	Hero he;
	Villain vi;

	public Window() {
		super("GALAGA TEST");
		setSize(800, 600);
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);
		hero = new Role();
		villain = new Role();
		he = new Hero(Window.this, vi);
		vi = new Villain(Window.this, he);
		he.setVillain(vi);
		villains = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			villains.add(new Villain(this, he)); // Agregar nuevos villanos
		}
		addKeyListener(he);
		setFocusable(true);

		Timer timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hero.move(he);
				hero.life(he);
				hero.shoot(he);
				hero.life(he);

				villain.move(vi);
				villain.shoot(vi);
				villain.life(vi);

				repaint();
			}
		});
		timer.start();

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.RED);
		g.drawLine(0, 396, 800, 396);
		hero.draw(g, he);
		villain.draw(g, vi);

		drawLifeBar(g);
		drawScore(g);

	}

	private void drawLifeBar(Graphics g) {
		int barWidth = 100; // Ancho de la barra de vida
		int barHeight = 20; // Alto de la barra de vida
		int x = 40; // Coordenada X de la barra de vida
		int y = 40; // Coordenada Y de la barra de vida
		int maxLife = 100; // Vida máxima
		int currentLife = he.getVida(); // Vida actual del héroe

		// Dibujar el contorno de la barra de vida
		g.setColor(Color.WHITE);
		g.drawRect(x, y, barWidth, barHeight);

		// Calcular la longitud de la barra de vida proporcional a la vida actual
		int lifeBarWidth = (int) (((double) currentLife / maxLife) * barWidth);

		// Dibujar la barra de vida proporcional
		g.setColor(Color.WHITE);
		g.fillRect(x, y, lifeBarWidth, barHeight);
	}

	private void drawScore(Graphics g) {
		// Definir posición del puntaje
		int x = getWidth() - 150;
		int y = 50;

		// Configurar el color y la fuente del puntaje
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 16));

		// Dibujar el puntaje en la ventana
		g.drawString("Score: " + vi.getScore(), x, y);

	}

}