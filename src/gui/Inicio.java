package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setTitle("Inicio");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Vehículos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guiVehiculos newframe = new guiVehiculos();
				newframe.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(66, 10, 115, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Repuestos");
		btnNewButton_1.setBounds(191, 10, 115, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Accesorios");
		btnNewButton_2.setBounds(316, 10, 116, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Servicios");
		btnNewButton_3.setBounds(442, 10, 115, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Tiendas");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(567, 10, 115, 27);
		contentPane.add(btnNewButton_4);
	}

}
