package vista_package;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import contolador_package.Container;

public class GameFrame extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Container container;

	public GameFrame() {
		super("***GALAGA***");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setBackground(Color.BLACK);

		setVisible(true);

		container = new Container();
		contentPane = new JPanel();
		contentPane.setBackground(Color.black);
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		addKeyListener(this);
		Timer timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				container.moveDown(1);
				container.moveUp(10);

				container.moveDownVillain(10);
				 //container.addShootV();

				repaint();
			}
		});
		timer.start();

	}

	public void paint(Graphics g) {
		super.paint(g);
		container.draws(g);
		container.drawShoot(g);
		container.drawShootV(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:

			container.moveLeft(30);
			break;
		case KeyEvent.VK_LEFT:

			container.moveLeft(30);
			break;
		case KeyEvent.VK_D:

			container.moveRight(30);
			break;

		case KeyEvent.VK_RIGHT:
			container.moveRight(30);
			break;
		case KeyEvent.VK_SPACE:
			container.drawShoot(getGraphics());
			container.addShoot();
			break;
		case KeyEvent.VK_ENTER:
			container.drawShootV(getGraphics());
			container.addShootV();
			break;
		default:

		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
	/*
	 * private void drawLifeBar(Graphics g) { int barWidth = 100; // Ancho de la
	 * barra de vida int barHeight = 20; // Alto de la barra de vida int x = 40; //
	 * Coordenada X de la barra de vida int y = 40; // Coordenada Y de la barra de
	 * vida int maxLife = 100; // Vida máxima int currentLife = container.live(); //
	 * Vida actual del héroe
	 * 
	 * // Dibujar el contorno de la barra de vida g.setColor(Color.WHITE);
	 * g.drawRect(x, y, barWidth, barHeight);
	 * 
	 * // Calcular la longitud de la barra de vida proporcional a la vida actual int
	 * lifeBarWidth = (int) (((double) currentLife / maxLife) * barWidth);
	 * 
	 * // Dibujar la barra de vida proporcional g.setColor(Color.WHITE);
	 * g.fillRect(x, y, lifeBarWidth, barHeight); g.setColor(Color.WHITE);
	 * g.setFont(new Font("Arial", Font.PLAIN, 12)); g.drawString("Life: " +
	 * currentLife, x + barWidth + 10, y + barHeight / 2); } private void
	 * drawScore(Graphics g) { // Definir posición del puntaje int x = getWidth() -
	 * 150; int y = 50;
	 * 
	 * // Configurar el color y la fuente del puntaje g.setColor(Color.WHITE);
	 * g.setFont(new Font("Arial", Font.BOLD, 16));
	 * 
	 * // Dibujar el puntaje en la ventana g.drawString("Score: " +
	 * container.score(), x, y);
	 * 
	 * }
	 */

}
