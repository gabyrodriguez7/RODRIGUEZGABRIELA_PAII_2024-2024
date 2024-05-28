package vista_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
	private GameOver end;
	
	private boolean gameOverDisplayed;
	
	public GameFrame() {
		super("***GALAGA***");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		addKeyListener(this);
		setFocusable(true);
        setVisible(true);
        
		container = new Container();
		contentPane = new JPanel();
		
		contentPane.setBackground(Color.black);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		Timer timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				container.moveDown(1);
				container.shoot();
				container.live();
				
				if (!gameOverDisplayed && container.live() <= 0) {
                    // Mostrar la ventana de Game Over solo si no se ha mostrado antes
                    end = new GameOver();
                    end.setVisible(true);
                    gameOverDisplayed = true;
                    
                }
				repaint();
			}
		});
		timer.start();
		

		

	}

	public void paint(Graphics g) {
		super.paint(g);
		container.draws(g);
		
		
		drawLifeBar(g);
		drawScore(g);
		
 
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_A :

			container.moveLeft(30);
			break;
			case KeyEvent.VK_LEFT :

			container.moveLeft(30);
			break;	
		case KeyEvent.VK_D:

			container.moveRight(30);
			break;
	
		case KeyEvent.VK_RIGHT:
			container.moveRight(30);
			break;
		default:

		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
	private void drawLifeBar(Graphics g) {
		int barWidth = 100; // Ancho de la barra de vida
		int barHeight = 20; // Alto de la barra de vida
		int x = 40; // Coordenada X de la barra de vida
		int y = 40; // Coordenada Y de la barra de vida
		int maxLife = 100; // Vida máxima
		int currentLife = container.live(); // Vida actual del héroe

		// Dibujar el contorno de la barra de vida
		g.setColor(Color.WHITE);
		g.drawRect(x, y, barWidth, barHeight);

		// Calcular la longitud de la barra de vida proporcional a la vida actual
		int lifeBarWidth = (int) (((double) currentLife / maxLife) * barWidth);

		// Dibujar la barra de vida proporcional
		g.setColor(Color.WHITE);
		g.fillRect(x, y, lifeBarWidth, barHeight);
		 g.setColor(Color.WHITE);
		    g.setFont(new Font("Arial", Font.PLAIN, 12)); 
		    g.drawString("Life: " + currentLife, x + barWidth + 10, y + barHeight / 2); 
	}
	private void drawScore(Graphics g) {
		// Definir posición del puntaje
		int x = getWidth() - 150;
		int y = 50;

		// Configurar el color y la fuente del puntaje
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 16));

		// Dibujar el puntaje en la ventana
		g.drawString("Score: " + container.score(), x, y);

	}

}
