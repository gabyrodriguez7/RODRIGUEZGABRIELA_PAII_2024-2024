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
import javax.swing.JTextField;

import controller.Container;

public class ProfesorFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdGuardar;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtAge;
	private JTextField txtIdBuscar;
	private JTextField txtIdActualizar;
	private JTextField txtNombreActualizar;
	private JTextField txtIdEliminar;
	Color color1 = new Color(0.756f, 0.8470f, 0.8470f);
	Color color2 = new Color(0.937f, 0.8470f, 0.7058f);
	Color color3 = new Color(0.886f, 0.619f, 0.6313f);

	Container controlador = new Container();


    public ProfesorFrame() {
        super("***Profesor***");


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);

		setVisible(true);

		contentPane = new JPanel();
		contentPane.setBackground(color1);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Titulo "Student"
		JLabel lblTitle = new JLabel("Student:");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblTitle.setBounds(10, 10, 100, 20);
		contentPane.add(lblTitle);

		// Campo de texto para ingresar el ID al guardar
		JLabel lblIdGuardar = new JLabel("ID:");
		lblIdGuardar.setBounds(10, 40, 100, 20);
		contentPane.add(lblIdGuardar);

		txtIdGuardar = new JTextField();
		txtIdGuardar.setBounds(120, 40, 200, 20);
		contentPane.add(txtIdGuardar);

		// Campos de texto para ingresar datos
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 70, 100, 20);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(120, 70, 200, 20);
		contentPane.add(txtName);

		JLabel lblLastName = new JLabel("Lastname:");
		lblLastName.setBounds(10, 100, 100, 20);
		contentPane.add(lblLastName);

		txtLastName = new JTextField();
		txtLastName.setBounds(120, 100, 200, 20);
		contentPane.add(txtLastName);

		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 130, 100, 20);
		contentPane.add(lblAge);

		txtAge = new JTextField();
		txtAge.setBounds(120, 130, 200, 20);
		contentPane.add(txtAge);

		JButton btnSave = new JButton("Guardar");
		btnSave.setBounds(350, 130, 100, 30);
		btnSave.setBackground(color2);
		btnSave.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPane.add(btnSave);

		// Etiqueta y campo de texto para buscar
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblBuscar.setBounds(10, 200, 100, 20);
		contentPane.add(lblBuscar);

		JLabel lblIngresarIdBuscar = new JLabel("Ingrese ID:");
		lblIngresarIdBuscar.setBounds(10, 230, 100, 20);
		contentPane.add(lblIngresarIdBuscar);

		txtIdBuscar = new JTextField();
		txtIdBuscar.setBounds(150, 230, 200, 20);
		contentPane.add(txtIdBuscar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(370, 230, 100, 20);
		btnBuscar.setBackground(color2);
		btnBuscar.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPane.add(btnBuscar);

		// Etiqueta y campos de texto para actualizar
		JLabel lblActualizar = new JLabel("Actualizar:");
		lblActualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblActualizar.setBounds(10, 280, 100, 20);
		contentPane.add(lblActualizar);

		JLabel lblIngresarIdActualizar = new JLabel("Ingrese ID:");
		lblIngresarIdActualizar.setBounds(10, 310, 100, 20);
		contentPane.add(lblIngresarIdActualizar);

		txtIdActualizar = new JTextField();
		txtIdActualizar.setBounds(150, 310, 200, 20);
		contentPane.add(txtIdActualizar);

		JLabel lblIngresarNombreActualizar = new JLabel("Nombre a Actualizar:");
		lblIngresarNombreActualizar.setBounds(10, 340, 200, 20);
		contentPane.add(lblIngresarNombreActualizar);

		txtNombreActualizar = new JTextField();
		txtNombreActualizar.setBounds(150, 340, 200, 20);
		contentPane.add(txtNombreActualizar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(370, 320, 100, 20);
		btnActualizar.setBackground(color2);
		btnActualizar.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPane.add(btnActualizar);

		// Etiqueta y campo de texto para eliminar
		JLabel lblEliminar = new JLabel("Eliminar:");
		lblEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblEliminar.setBounds(10, 420, 100, 20);
		contentPane.add(lblEliminar);

		JLabel lblIngresarIdEliminar = new JLabel("Ingrese ID:");
		lblIngresarIdEliminar.setBounds(10, 450, 100, 20);
		contentPane.add(lblIngresarIdEliminar);

		txtIdEliminar = new JTextField();
		txtIdEliminar.setBounds(150, 450, 200, 20);
		contentPane.add(txtIdEliminar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(370, 450, 100, 20);
		btnEliminar.setBackground(color2);
		btnEliminar.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPane.add(btnEliminar);
		
		 JButton Regresar = new JButton("Regresar");
	        Regresar.setBounds(250, 520, 100, 20);
	        Regresar.setBackground(color3);
	        Regresar.setBorder(BorderFactory.createRaisedBevelBorder());
	        contentPane.add(Regresar);
		// FUNCIONALIDAD

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
				int id = Integer.parseInt(txtIdGuardar.getText());
				String name = txtName.getText();
				String lastName = txtLastName.getText();
				int age = Integer.parseInt(txtAge.getText());

			
				controlador.createProfessor(id, name, lastName, age);

			}
		});
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtIdBuscar.getText());
				controlador.readProfessor(id);

			}
		});

		btnActualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(txtIdActualizar.getText());
				String actualizar = txtNombreActualizar.getText();

				controlador.updateProfessor(id, actualizar);

			}
		});
		
		
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(txtIdEliminar.getText());

				controlador.deleteProfessor(id);

			}
		});
		 Regresar.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                ProfesorFrame.this.dispose();
	            	MenuPrincipal menu = new MenuPrincipal();

	            }
	        });
    }

}
