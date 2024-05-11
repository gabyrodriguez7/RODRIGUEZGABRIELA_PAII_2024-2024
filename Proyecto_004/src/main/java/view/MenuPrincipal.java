package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Color color1 = new Color(0.756f, 0.8470f, 0.8470f);
	Color color2 = new Color(0.937f, 0.8470f, 0.7058f);
	Color color3 = new Color(0.886f, 0.619f, 0.6313f);

	public MenuPrincipal() {
		super("***Menu***");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);

		setVisible(true);
        
		contentPane = new JPanel();
		contentPane.setBackground(color1);
		setContentPane(contentPane);
		contentPane.setLayout(null);

	
		JLabel lblBienvenidos = new JLabel("Bienvenidos al sistema de registro");
		lblBienvenidos.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
		lblBienvenidos.setBounds(70, 100, 400, 35); 
		contentPane.add(lblBienvenidos); 

		
		JLabel lblSelecciona = new JLabel("Selecciona:");
		lblSelecciona.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblSelecciona.setBounds(100, 150, 100, 20); 
		contentPane.add(lblSelecciona); 

		// Botón para Student
		JButton btnStudent = new JButton("Student");
		btnStudent.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnStudent.setBounds(225, 200, 150, 30); 
		btnStudent.setBackground(color2);
		btnStudent.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPane.add(btnStudent); 

		btnStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.this.dispose(); 
				EstudianteFrame estudianteFrame = new EstudianteFrame();
				estudianteFrame.setVisible(true);
			}
		});

		// Botón para Professor
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnProfessor.setBounds(225, 250, 150, 30); 
		btnProfessor.setBackground(color2);
		btnProfessor.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPane.add(btnProfessor); 
		
		btnProfessor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.this.dispose(); 
				ProfesorFrame profesorFrame = new ProfesorFrame();
				profesorFrame.setVisible(true);
			}
		});
		
		// Botón para Subject
		JButton btnSubject = new JButton("Subject");
		btnSubject.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnSubject.setBounds(225, 300, 150, 30);
		btnSubject.setBackground(color2);
		btnSubject.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPane.add(btnSubject); 

		btnSubject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.this.dispose(); 
				MateriaFrame materiaFrame = new MateriaFrame();
				materiaFrame.setVisible(true);
			}
		});
		
		// Botón para Schedule
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnSchedule.setBounds(225, 350, 150, 30); 
		btnSchedule.setBackground(color2);
		btnSchedule.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPane.add(btnSchedule); 

		btnSchedule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.this.dispose(); 
				HorarioFrame horarioFrame = new HorarioFrame();
				horarioFrame.setVisible(true);
			}
		});
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnSalir.setBounds(225, 450, 150, 30);
		btnSalir.setBackground(color3);
		btnSalir.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPane.add(btnSalir);

		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.this.dispose(); 

			}
		});
		
		setLocationRelativeTo(null);
		
	}

}
