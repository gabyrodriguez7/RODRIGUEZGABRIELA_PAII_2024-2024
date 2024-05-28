package vista_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOver extends JFrame {

	private static final long serialVersionUID = 1L;
	private boolean gameOverDisplayed = false;
	private JPanel contentPane;
	
	int score;
	int life;

	public GameOver() {
		super("---Game Over---");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);

		setFocusable(true);

		contentPane = new JPanel();
		contentPane.setBackground(Color.black);
		setContentPane(contentPane);

	

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if (!gameOverDisplayed) { // Verificar si la ventana aún no se ha mostrado
			drawScore(g);
			gameOverDisplayed = true; // Establecer la bandera a true para indicar que la ventana se ha mostrado
		}

		
		
	}

	private void drawScore(Graphics g) {
		// Definir posición del puntaje
		int x = getWidth() - 250;
		int y = 150;

		// Configurar el color y la fuente del puntaje
		g.setColor(Color.red);
		g.setFont(new Font("Arial", Font.BOLD, 40));

		// Dibujar el puntaje en la ventana
		g.drawString("Game Over", x, y);

		/*
		  /////////////////////////////////////////////////////
		  
		  // Configurar el color y la fuente del puntaje g.setColor(Color.BLACK);
		  g.setFont(new Font("Arial", Font.BOLD, 25));
		  
		  g.drawString("Score :"+ score, x, y + 75);
		  
		  ////////////////////////////////////////////////////////////
		
		  g.setColor(Color.BLACK); g.setFont(new Font("Arial", Font.BOLD, 25));
		  
		  g.drawString("Su vida es: "+ life, x, y + 150);
		  */
		  
		  
		 

	}
	
	/*public void life(int vida) {
		this.life = life;

	}
	public void score(int score) {
		this.score = score;

	}*/
}
