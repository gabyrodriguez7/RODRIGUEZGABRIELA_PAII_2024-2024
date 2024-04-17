package Paquete1;
/**
 *
 *
 *  @author:Gabriela Rodríguez
 *  Titulo: Dibujar con openGL figuras básicas
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;

public class Ventana {
	private JFrame frame;
	private GLCanvas canvas;
	private Animator animator;

	public Ventana() {
		crearVentanaBotones();
		inicializarCanvas();
	}

	private void crearVentanaBotones() {
		frame = new JFrame("Botones");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel, BorderLayout.CENTER);

		JButton btn1 = new JButton("Triángulo");
		btn1.setBackground(Color.cyan);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dibujarTriangulo();
			}
		});
		panel.add(btn1);

		JButton btn2 = new JButton("Cuadrado");
		btn2.setBackground(Color.cyan);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dibujarCuadrado();
			}
		});
		panel.add(btn2);

		JButton btn3 = new JButton("Círculo");
		btn3.setBackground(Color.cyan);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dibujarCirculo();
			}
		});
		panel.add(btn3);

		frame.setSize(400, 100);
		frame.setLocation(500, 140);
		frame.setVisible(true);
	}

	//área rectangular en la pantalla en la que se pueden dibujar 
	//gráficos, texto u otros elementos visuales
	private void inicializarCanvas() {
		GLProfile glp = GLProfile.getDefault();
		GLCapabilities caps = new GLCapabilities(glp);

		canvas = new GLCanvas(caps);
		canvas.addGLEventListener(new MyGLEventListener());

		JFrame glFrame = new JFrame("Dibujo en OpenGL");
		glFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		glFrame.getContentPane().add(canvas, BorderLayout.CENTER);
		glFrame.setSize(400, 400);
		glFrame.setLocation(500, 233);
		glFrame.setVisible(true);
        
		//Controla la animacion en OpenGL asociado a Canvas
		animator = new Animator(canvas);
		animator.start();
	}

	private void dibujarTriangulo() {
		canvas.addGLEventListener(new MyGLEventListener() {
			@Override
			public void display(GLAutoDrawable drawable) {
				super.display(drawable);
				GL2 gl = drawable.getGL().getGL2();
				gl.glClear(GL.GL_COLOR_BUFFER_BIT);
				gl.glBegin(GL.GL_TRIANGLES);
				gl.glColor3f(0.93f, 0.21f, 0.96f); // Color Lavanda
				gl.glVertex2f(-0.8f, -0.8f); // Vértice inferior izquierdo
				gl.glVertex2f(0.8f, -0.8f); // Vértice inferior derecho
				gl.glVertex2f(0.0f, 0.8f); // Vértice superior
				gl.glEnd();
			}
		});
		canvas.display();
	}

	private void dibujarCuadrado() {

		canvas.addGLEventListener(new MyGLEventListener() {
			@Override
			public void display(GLAutoDrawable drawable) {
				super.display(drawable);
				GL2 gl = drawable.getGL().getGL2();
				gl.glClear(GL.GL_COLOR_BUFFER_BIT);
				gl.glBegin(GL.GL_TRIANGLE_FAN);
				gl.glColor3f(0.78f, 0.02f, 0.62f); // Color Morado
				gl.glVertex2f(-0.7f, -0.7f); // Vértice inferior izquierdo
				gl.glVertex2f(-0.7f, 0.7f); // Vértice superior izquierdo
				gl.glVertex2f(0.7f, 0.7f); // Vértice superior derecho
				gl.glVertex2f(0.7f, -0.7f); // Vértice inferior derecho
				gl.glEnd();
			}
		});
		canvas.display();
	}

	private void dibujarCirculo() {
		canvas.addGLEventListener(new MyGLEventListener() {
			@Override
			public void display(GLAutoDrawable drawable) {
				super.display(drawable);
				GL2 gl = drawable.getGL().getGL2();
				gl.glClear(GL.GL_COLOR_BUFFER_BIT);
				int sides = 100;
				double radius = 0.8;
				double twicePi = 3.0 * Math.PI;
				gl.glBegin(GL.GL_TRIANGLE_FAN);
				gl.glColor3f(0.45f, 1.0f, 0.62f); // Color Verde
				gl.glVertex2d(0, 0); // Centro del círculo
				for (int i = 0; i <= sides; i++) {
					double x = radius * Math.cos(i * twicePi / sides);
					double y = radius * Math.sin(i * twicePi / sides);
					gl.glVertex2d(x, y);
				}
				gl.glEnd();
			}
		});
		canvas.display();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Ventana();
			}
		});
	}
}