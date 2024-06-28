package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel; 
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import clases.Venta;
import arreglo.ArregloVenta;
public class guiVehiculos extends JFrame implements ActionListener {
	
	
	private DefaultTableModel modelo;
	ArregloVenta aa = new ArregloVenta();
	
	//Implementa el metodo Listar
			void Listar(ArregloVenta objeto) {
				modelo.setRowCount(0); 
				for(int i=0; i<objeto.tamaño(); i++) {
					int cod =aa.obtener(i).getCodigo();
					String tip= aa.obtener(i).getTipo();
					String mar= aa.obtener(i).getMarca();
					Double pre =aa.obtener(i).getPrecio();
					String pot= aa.obtener(i).getPotencia();
					String des= aa.obtener(i).getDescripcion();
					
					
					Object[] fila = { cod, tip, mar, pre, pot, des};
					modelo.addRow(fila);
				}
				tblTabla.setModel(modelo);
				 
			}
			
		void LimpiarControles() {
			txtCodigo.setText("");
	        txtTipo.setText("");
	        txtMarca.setText("");
	        txtPrecio.setText("");
	        txtPotencia.setText("");
	        txtDescripcion.setText("");
	        txtCodigo.requestFocus();
		}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblTipoDeAuto;
	private JLabel lblMarca;
	private JLabel lblPrecio;
	private JLabel lblPotencia;
	private JLabel lblDescripcin;
	private JTextField txtCodigo;
	private JTextField txtTipo;
	private JTextField txtMarca;
	private JTextField txtPrecio;
	private JTextField txtPotencia;
	private JTextField txtDescripcion;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnImprimir;
	private JScrollPane scrollPane;
	private JTable tblTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiVehiculos frame = new guiVehiculos();
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
	public guiVehiculos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setTitle("Vehiculos");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(10, 11, 65, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		lblTipoDeAuto = new JLabel("Tipo:");
		lblTipoDeAuto.setBounds(86, 11, 65, 22);
		lblTipoDeAuto.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblTipoDeAuto);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(161, 11, 65, 22);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblMarca);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(250, 11, 65, 22);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPrecio);
		
		lblPotencia = new JLabel("Potencia:");
		lblPotencia.setBounds(336, 11, 77, 22);
		lblPotencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPotencia);
		
		lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(423, 11, 97, 22);
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblDescripcin);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 36, 65, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(86, 36, 65, 20);
		txtTipo.setColumns(10);
		contentPane.add(txtTipo);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(161, 36, 65, 20);
		txtMarca.setColumns(10);
		contentPane.add(txtMarca);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(250, 36, 76, 20);
		txtPrecio.setColumns(10);
		contentPane.add(txtPrecio);
		
		txtPotencia = new JTextField();
		txtPotencia.setBounds(336, 36, 77, 20);
		txtPotencia.setColumns(10);
		contentPane.add(txtPotencia);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(423, 36, 230, 20);
		txtDescripcion.setColumns(10);
		contentPane.add(txtDescripcion);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 90, 102, 23);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(10, 135, 102, 23);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(10, 181, 102, 23);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(10, 226, 102, 23);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnEliminar);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(this);
		btnImprimir.setBounds(10, 300, 102, 23);
		btnImprimir.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnImprimir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 67, 550, 300);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		//Modelo
		modelo = new DefaultTableModel(); 
		modelo.addColumn("Código"); 
		modelo.addColumn("Tipo Auto"); 
		modelo.addColumn("Marca"); 
		modelo.addColumn("Precio"); 
		modelo.addColumn("Potencia"); 
		modelo.addColumn("Descripcion");
		
		tblTabla.setModel(modelo); 
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(e);
		}
	}
	protected void actionPerformedBtnImprimir(ActionEvent e) {
		LimpiarControles();
		Listar(aa);
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		// Adicionar :
        // adiciona un nuevo alumno verificando que el código no se repita.
        int cod = Integer.parseInt(txtCodigo.getText());
        String tip = txtTipo.getText().toString();
        String mar = txtMarca.getText().toString();
        Double pre = Double.parseDouble(txtPrecio.getText());
        String pot = txtPotencia.getText().toString();
        String des = txtDescripcion.getText().toString();
        
        // buscando el codigo si existe o no.
        Venta resultado = aa.buscar(cod);
        if (resultado == null) {
            aa.adicionar(new Venta(cod, tip, mar, pre, pot, des));
            modelo.setRowCount(0); tblTabla.setModel(modelo);
            LimpiarControles();
            Listar(aa);
            JOptionPane.showMessageDialog(null,"Registro Almacenado");
        } else {
            LimpiarControles();
            JOptionPane.showMessageDialog(null,"El Registro ya Existe, no se puede grabar\n");
        }
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		int cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo"));
        //int cod = Integer.parseInt(txtCodigo.getText());
        Venta Resultado = aa.buscar(cod);
        int pos = aa.buscarPosicion(cod);
        if (Resultado != null) {
            txtCodigo.setText(Integer.toString(aa.obtener(pos).getCodigo()));
            txtTipo.setText(aa.obtener(pos).getTipo());
            txtMarca.setText(aa.obtener(pos).getMarca());
            txtPrecio.setText(Double.toString(aa.obtener(pos).getPrecio()));
            txtPotencia.setText(aa.obtener(pos).getPotencia());
            txtDescripcion.setText(aa.obtener(pos).getDescripcion());
            
            
            // En la tabla
            cod = aa.obtener(pos).getCodigo();
            String tip = aa.obtener(pos).getTipo();
            String mar = aa.obtener(pos).getMarca();
            double pre = aa.obtener(pos).getPrecio();
            String pot = aa.obtener(pos).getPotencia();
            String des = aa.obtener(pos).getDescripcion();
            modelo.setRowCount(0);
            Object[] fila = { cod, tip, mar, pre, pot, des};
            modelo.addRow(fila);
            tblTabla.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(null, "Registro no Encontrado");
            LimpiarControles();
        }
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int cod =Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo"));
        Venta Resultado = aa.buscar(cod);
        if (Resultado != null) {
            aa.eliminar(Resultado);
            Listar(aa);
            //LimpiarControles();
        } else {
            JOptionPane.showMessageDialog(null, "Registro no Encontrado");
            LimpiarControles();
        }
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		int cod =Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo"));
        Venta Resultado = aa.buscar(cod);
        int pos = aa.buscarPosicion(cod);
        if (Resultado != null) {
            cod = Integer.parseInt(txtCodigo.getText());
            String tip = txtTipo.getText().toString();
            String mar = txtMarca.getText().toString();
            Double pre = Double.parseDouble(txtPrecio.getText());
            String pot = txtPotencia.getText().toString();
            String des = txtDescripcion.getText().toString();
            Resultado.setCodigo(cod);
            Resultado.setTipo(tip);
            Resultado.setMarca(mar);
            Resultado.setPrecio(pre);
            Resultado.setPotencia(pot);
            Resultado.setDescripcion(des);
            aa.modificar(pos, Resultado);
            Listar(aa);
            LimpiarControles();
        } else {
            JOptionPane.showMessageDialog(null, "Registro no Encontrado");
            LimpiarControles();
        }
	}
}
