package gui;


import java.awt.EventQueue;

import clases.Accesorios;
import arreglo.ArregloAccesorios;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import funciones.Concesionario_FuncionesPublicas;
import java.awt.Font;

public class guiAccesorios extends JFrame implements ActionListener {
	


	private DefaultTableModel modelo;
	
	
	ArregloAccesorios aa= new ArregloAccesorios();
	Concesionario_FuncionesPublicas fp = new Concesionario_FuncionesPublicas();
	
	void Listar(ArregloAccesorios objeto) {
		modelo.setRowCount(0); 
		for(int i=0;i<objeto.tamano();i++) {
			int cod = aa.obtener(i).getCodigo();
			String nom= aa.obtener(i).getNombre();
			String mar= aa.obtener(i).getMarca();
			int pre =  aa.obtener(i).getPrecio();
			int uni=  aa.obtener(i).getUnidades();
			String sto= aa.obtener(i).estado();
			
			
			Object[] fila = { cod, nom , mar ,pre, uni, sto };
			modelo.addRow(fila);
		}
			
		tableAccesorios.setModel(modelo);	
		
	}
	
	void LimpiarControles() {
		txtcodigo.setText("");
		txtnombre.setText("");
		txtmarca.setText("");
		txtprecio.setText("");
		txtunidades.setText("");
		modelo.setRowCount(0);
		tableAccesorios.setModel(modelo);
		txtcodigo.requestFocus();
	}
	
	private JPanel contentPane;
	private JButton btnadicionar;
	private JButton btnconsultar;
	private JButton btnmodificar;
	private JButton btneliminar;
	private JButton btnimprimir;
	private JTextField txtcodigo;
	private JTextField txtnombre;
	private JTextField txtmarca;
	private JTextField txtprecio;
	private JTextField txtunidades;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblUnidades;
	private JScrollPane scrollPane;
	private JTable tableAccesorios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiAccesorios frame = new guiAccesorios();
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
	private static final long serialVersionUID = 1L;
	private JButton btnListar;
	public guiAccesorios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Accesorios");
		
		btnadicionar = new JButton("Adicionar");
		btnadicionar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnadicionar.addActionListener(this);
		btnadicionar.setBounds(10, 107, 107, 23);
		contentPane.add(btnadicionar);
		
		btnconsultar = new JButton("Consultar");
		btnconsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnconsultar.addActionListener(this);
		btnconsultar.setBounds(10, 141, 107, 23);
		contentPane.add(btnconsultar);
		
		btnmodificar = new JButton("Modificar");
		btnmodificar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnmodificar.addActionListener(this);
		btnmodificar.setBounds(10, 175, 107, 23);
		contentPane.add(btnmodificar);
		
		btneliminar = new JButton("Eliminar");
		btneliminar.setFont(new Font("Arial", Font.PLAIN, 14));
		btneliminar.addActionListener(this);
		btneliminar.setBounds(10, 209, 107, 23);
		contentPane.add(btneliminar);
		
		btnimprimir = new JButton("Imprimir");
		btnimprimir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnimprimir.addActionListener(this);
		btnimprimir.setBounds(10, 401, 107, 23);
		contentPane.add(btnimprimir);
		
		txtcodigo = new JTextField();
		txtcodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtcodigo.setBounds(10, 45, 86, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setFont(new Font("Arial", Font.PLAIN, 12));
		txtnombre.setBounds(157, 45, 86, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtmarca = new JTextField();
		txtmarca.setFont(new Font("Arial", Font.PLAIN, 12));
		txtmarca.setBounds(288, 45, 86, 20);
		contentPane.add(txtmarca);
		txtmarca.setColumns(10);
		
		txtprecio = new JTextField();
		txtprecio.setFont(new Font("Arial", Font.PLAIN, 12));
		txtprecio.setBounds(419, 45, 86, 20);
		contentPane.add(txtprecio);
		txtprecio.setColumns(10);
		
		txtunidades = new JTextField();
		txtunidades.setFont(new Font("Arial", Font.PLAIN, 12));
		txtunidades.setBounds(572, 45, 86, 20);
		contentPane.add(txtunidades);
		txtunidades.setColumns(10);
		
		lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 20, 62, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Accesorio:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(157, 20, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(288, 20, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(419, 20, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		lblUnidades = new JLabel("Unidades:");
		lblUnidades.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUnidades.setBounds(572, 20, 86, 14);
		contentPane.add(lblUnidades);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 93, 619, 339);
		contentPane.add(scrollPane);
		
		tableAccesorios = new JTable();
		tableAccesorios.setFont(new Font("Consolas", Font.BOLD, 14));
		tableAccesorios.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableAccesorios);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código"); 
		modelo.addColumn("Nombre"); 
		modelo.addColumn("Marca"); 
		modelo.addColumn("Precio"); 
		modelo.addColumn("Unidades"); 
		modelo.addColumn("Stock");
		tableAccesorios.setModel(modelo); 
		
		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Listar(aa);
				
			}
		});
		btnListar.setBounds(10, 242, 107, 23);
		contentPane.add(btnListar);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btneliminar) {
			actionPerformedBtneliminar(e);
		}
		if (e.getSource() == btnmodificar) {
			actionPerformedBtnmodificar(e);
		}
		if (e.getSource() == btnconsultar) {
			actionPerformedBtnconsultar(e);
		}
		if (e.getSource() == btnadicionar) {
			actionPerformedBtnadicionar(e);
		}
		if (e.getSource() == btnimprimir) {
			actionPerformedBtnimprimir(e);
		}
	}
	protected void actionPerformedBtnimprimir(ActionEvent e) {
		
		imprimirRepuestos();
		
	}
	protected void actionPerformedBtnadicionar(ActionEvent e) {
		
		if (txtcodigo.getText().isEmpty() || txtnombre.getText().isEmpty() || txtmarca.getText().isEmpty() ||
		        txtprecio.getText().isEmpty() || txtunidades.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Cuadros vac�os, porfavor, rellene lo que desea adicionar \n");
		        return;
		    }
		
		//adiciona un nuevo alumno, verificando que el codigo no se repita
		int cod = Integer.parseInt(txtcodigo.getText());
		String nom=txtnombre.getText().toString();
		String mar=txtmarca.getText().toString();
		int pre= Integer.parseInt(txtprecio.getText());
		int uni= Integer.parseInt(txtunidades.getText());
		//buscando el codigo
		
		Accesorios resultado = aa.buscar(cod);
		if ( resultado==null) {
			aa.adicionar(new Accesorios( cod,nom,mar,pre,uni));
			modelo.setRowCount(0); tableAccesorios.setModel(modelo);
			LimpiarControles();
			Listar(aa);
			JOptionPane.showMessageDialog(null,"Registro realizado \n");
		} else {
			LimpiarControles();
			JOptionPane.showMessageDialog(null,"El registro ya existe, no se puede grabar \n");
		}
		
	}
	protected void actionPerformedBtnconsultar(ActionEvent e) {
		 int cod;
		    try {
		        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo"));
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "C�digo no v�lido");
		        return;
		    }
		    
		    Accesorios resultado = aa.buscar(cod);
		    //int pos = aa.buscarPosicion(cod);
		    
		    if (resultado != null) {
		        
		        DefaultTableModel modeloTabla = (DefaultTableModel) tableAccesorios.getModel();
		        modeloTabla.setRowCount(0); 
		        
		        
		        Object[] fila = {resultado.getCodigo(), resultado.getNombre(), resultado.getMarca(),
		                         resultado.getPrecio(), resultado.getUnidades()};
		        modeloTabla.addRow(fila);
		        
		        
		        tableAccesorios.setModel(modeloTabla);
		    } else {
		        JOptionPane.showMessageDialog(null, "Registro no encontrado");
		        LimpiarControles(); 
		    }
		
		
		
	}
	protected void actionPerformedBtnmodificar(ActionEvent e) {
		int cod;
	    try {
	        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo"));
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "C�digo no v�lido");
	        return;
	    }
	    
	    Accesorios resultado = aa.buscar(cod);
	    int pos = aa.buscarPosicion(cod);
	    
	    if (resultado != null) {
	        if (txtcodigo.getText().isEmpty() || txtnombre.getText().isEmpty() || txtmarca.getText().isEmpty() ||
	            txtprecio.getText().isEmpty() || txtunidades.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Cuadros vac�os, porfavor, rellene la nueva informacion a modificar \n");
	            return;
	        }
	        
	        try {
	            int nuevoCod = Integer.parseInt(txtcodigo.getText());
	            String nom = txtnombre.getText();
	            String mar = txtmarca.getText();
	            int pre = Integer.parseInt(txtprecio.getText());
	            int uni = Integer.parseInt(txtunidades.getText());

	            
	            resultado.setCodigo(nuevoCod);
	            resultado.setNombre(nom);
	            resultado.setMarca(mar);
	            resultado.setPrecio(pre);
	            resultado.setUnidades(uni);
	            aa.modificar(pos, resultado);

	            
	            modelo.setRowCount(0);
	            tableAccesorios.setModel(modelo);
	            Listar(aa);
	            LimpiarControles();
	            JOptionPane.showMessageDialog(null, "Registro modificado \n");
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores num�ricos v�lidos");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Registro no encontrado");
	        LimpiarControles();
	    }
		
	}
	protected void actionPerformedBtneliminar(ActionEvent e) {
		
		int cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo"));
		Accesorios Resultado = aa.buscar(cod);
		if(Resultado!= null) {
			aa.eliminar(Resultado);
			Listar(aa);
			
		} else {
			JOptionPane.showMessageDialog(null, "Registro no Encontrado" );
			LimpiarControles();
		}
	}
	
	private void imprimirRepuestos() {
    	fp.exportarTablaEnFormatoCSV(modelo, this);
	}
}
