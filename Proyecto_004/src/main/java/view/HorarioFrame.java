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

public class HorarioFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtIdMateria;
    private JTextField txtIdEstudiante;
    private JTextField txtIdProfesor;
    private JTextField txtHoraInicio;
    private JTextField txtHoraFin;
    private JTextField txtDia;
    private JTextField txtIdBuscar;
    private JTextField txtIdActualizar;
    private JTextField txtNombreDia;
    private JTextField txtIdEliminar;
    private JTextField txtIdEliminar2;
    Color color1 = new Color(0.756f, 0.8470f, 0.8470f);
	Color color2 = new Color(0.937f, 0.8470f, 0.7058f);
	Color color3 = new Color(0.886f, 0.619f, 0.6313f);
    
    Container controlador = new Container();
    public HorarioFrame() {
        super("***Horario***");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        setVisible(true);

        contentPane = new JPanel();
        contentPane.setBackground(color1);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Titulo "Ingresar"
        JLabel lblIngresar = new JLabel("Ingresar:");
        lblIngresar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        lblIngresar.setBounds(10, 10, 100, 20);
        contentPane.add(lblIngresar);

        // Campos de texto para ingresar datos
        JLabel lblIdMateria = new JLabel("ID Materia:");
        lblIdMateria.setBounds(10, 40, 100, 20);
        contentPane.add(lblIdMateria);

        txtIdMateria = new JTextField();
        txtIdMateria.setBounds(120, 40, 200, 20);
        contentPane.add(txtIdMateria);

        JLabel lblIdEstudiante = new JLabel("ID Estudiante:");
        lblIdEstudiante.setBounds(10, 70, 100, 20);
        contentPane.add(lblIdEstudiante);

        txtIdEstudiante = new JTextField();
        txtIdEstudiante.setBounds(120, 70, 200, 20);
        contentPane.add(txtIdEstudiante);

        JLabel lblIdProfesor = new JLabel("ID Profesor:");
        lblIdProfesor.setBounds(10, 100, 100, 20);
        contentPane.add(lblIdProfesor);

        txtIdProfesor = new JTextField();
        txtIdProfesor.setBounds(120, 100, 200, 20);
        contentPane.add(txtIdProfesor);

        JLabel lblHoraInicio = new JLabel("Hora de Inicio:");
        lblHoraInicio.setBounds(10, 130, 100, 20);
        contentPane.add(lblHoraInicio);

        txtHoraInicio = new JTextField();
        txtHoraInicio.setBounds(120, 130, 200, 20);
        contentPane.add(txtHoraInicio);

        JLabel lblHoraFin = new JLabel("Hora de Fin:");
        lblHoraFin.setBounds(10, 160, 100, 20);
        contentPane.add(lblHoraFin);

        txtHoraFin = new JTextField();
        txtHoraFin.setBounds(120, 160, 200, 20);
        contentPane.add(txtHoraFin);

        JLabel lblDia = new JLabel("Día:");
        lblDia.setBounds(10, 190, 100, 20);
        contentPane.add(lblDia);

        txtDia = new JTextField();
        txtDia.setBounds(120, 190, 200, 20);
        contentPane.add(txtDia);

        // Boton para guardar datos
        JButton btnSave = new JButton("Guardar");
        btnSave.setBounds(400, 100, 100, 30);
        btnSave.setBackground(color2);
		btnSave.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(btnSave);

        // Etiqueta y campo de texto para buscar
        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        lblBuscar.setBounds(10, 220, 100, 20);
        contentPane.add(lblBuscar);

        JLabel lblIdBuscar = new JLabel("Ingresar ID:");
        lblIdBuscar.setBounds(10, 250, 100, 20);
        contentPane.add(lblIdBuscar);

        txtIdBuscar = new JTextField();
        txtIdBuscar.setBounds(220, 250, 200, 20);
        contentPane.add(txtIdBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(450, 250, 100, 20);
        btnBuscar.setBackground(color2);
		btnBuscar.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(btnBuscar);

        // Etiqueta y campos de texto para actualizar
        JLabel lblActualizar = new JLabel("Actualizar:");
        lblActualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        lblActualizar.setBounds(10, 300, 100, 20);
        contentPane.add(lblActualizar);

        JLabel lblIdActualizar = new JLabel("Ingresar ID:");
        lblIdActualizar.setBounds(10, 330, 100, 20);
        contentPane.add(lblIdActualizar);

        txtIdActualizar = new JTextField();
        txtIdActualizar.setBounds(220, 330, 200, 20);
        contentPane.add(txtIdActualizar);

        JLabel lblNombreDia = new JLabel("Actualizar Día:");
        lblNombreDia.setBounds(10, 360, 100, 20);
        contentPane.add(lblNombreDia);

        txtNombreDia = new JTextField();
        txtNombreDia.setBounds(220, 360, 200, 20);
        contentPane.add(txtNombreDia);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(450, 345, 100, 20);
        btnActualizar.setBackground(color2);
		btnActualizar.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(btnActualizar);

        // Etiqueta y campos de texto para eliminar
        JLabel lblEliminar = new JLabel("Eliminar:");
        lblEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        lblEliminar.setBounds(10, 410, 100, 20);
        contentPane.add(lblEliminar);

        JLabel lblIdEliminar = new JLabel("Ingresar ID de la materia:");
        lblIdEliminar.setBounds(10, 440, 200, 20);
        contentPane.add(lblIdEliminar);

        txtIdEliminar = new JTextField();
        txtIdEliminar.setBounds(220, 440, 200, 20);
        contentPane.add(txtIdEliminar);

        JLabel lblIdEliminar2 = new JLabel("Ingresar ID de alumno:");
        lblIdEliminar2.setBounds(10, 470, 200, 20);
        contentPane.add(lblIdEliminar2);

        txtIdEliminar2 = new JTextField();
        txtIdEliminar2.setBounds(220, 470, 200, 20);
        contentPane.add(txtIdEliminar2);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(450, 455, 100, 20);
        btnEliminar.setBackground(color2);
		btnEliminar.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(btnEliminar);
        
        JButton Regresar = new JButton("Regresar");
        Regresar.setBounds(250, 520, 100, 20);
        Regresar.setBackground(color3);
        Regresar.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(Regresar);

        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtIdMateria.getText());
                int id2 = Integer.parseInt(txtIdEstudiante.getText());
                int id3 = Integer.parseInt(txtIdProfesor.getText());
                String hora_inicio = txtHoraInicio.getText();
                String hora_Fin = txtHoraFin.getText();
                String dia = txtDia.getText();

                controlador.createSchedule(id, id2, id3, hora_inicio, hora_Fin, dia);

            }
        });
        btnBuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtIdBuscar.getText());
                controlador.readSchedule(id);

            }
        });

        btnActualizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(txtIdActualizar.getText());
                String actualizar = txtNombreDia.getText();

                controlador.updateSchedule(id, actualizar);

            }
        });

        btnEliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(txtIdEliminar.getText());
                int id2 = Integer.parseInt(txtIdEliminar2.getText());

                controlador.deleteSchedule(id, id2);

            }
        });
        Regresar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                HorarioFrame.this.dispose();
            	MenuPrincipal menu = new MenuPrincipal();
            	
            }
        });

        
    }

}
