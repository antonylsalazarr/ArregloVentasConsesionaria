package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class Ingreso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingreso frame = new Ingreso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ingreso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setTitle("Ingreso");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsuario.setBounds(164, 77, 238, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(96, 80, 58, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(78, 109, 76, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					if (String.valueOf(txtUsuario.getText()).compareTo("admin") == 0 && String.valueOf(txtContrasena.getPassword()).compareTo("1234") == 0) {
						Inicio newframe = new Inicio();
						newframe.setVisible(true);
						dispose();
						}
					else{
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
						}
			}
		});
		btnIngresar.setBounds(164, 152, 85, 21);
		contentPane.add(btnIngresar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtUsuario.setText("");
				txtContrasena.setText("");
				txtUsuario.requestFocus();
				
			}
		});
		btnCancelar.setBounds(286, 152, 85, 21);
		contentPane.add(btnCancelar);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		txtContrasena.setFont(new Font("Arial", Font.PLAIN, 12));
		txtContrasena.setBounds(164, 106, 238, 19);
		contentPane.add(txtContrasena);
	}
}
