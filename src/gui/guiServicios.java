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
import clases.Servicio;
import arreglo.ArregloServicios;
import funciones.Concesionario_FuncionesPublicas;



public class guiServicios extends JFrame implements ActionListener {
	
	
	private DefaultTableModel modelo;
	ArregloServicios aa = new ArregloServicios();
	Concesionario_FuncionesPublicas fp = new Concesionario_FuncionesPublicas();
	
			void Listar(ArregloServicios objeto) {
				modelo.setRowCount(0); 
				for(int i=0; i<objeto.tamaño(); i++) {
					int cod =aa.obtener(i).getCodigo();
					String tip= aa.obtener(i).getTipo();
					String fec= aa.obtener(i).getFecha();
					String hor= aa.obtener(i).getHora();
					Double pre =aa.obtener(i).getPrecio();
					String des= aa.obtener(i).getDescripcion();
					
					
					Object[] fila = { cod, tip, fec, hor, pre,des};
					modelo.addRow(fila);
				}
				tblTabla.setModel(modelo);
				 
			}
			
		void LimpiarControles() {
			txtCodigo.setText("");
	        txtTipo.setText("");
	        txtFecha.setText("");
	        txtHora.setText("");
	        txtPrecio.setText("");
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
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtPrecio;
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
					guiServicios frame = new guiServicios();
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
	public guiServicios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 832, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setTitle("Servicios");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(10, 11, 65, 22);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		lblTipoDeAuto = new JLabel("Tipo Servicio:");
		lblTipoDeAuto.setBounds(74, 11, 105, 22);
		lblTipoDeAuto.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblTipoDeAuto);
		
		lblMarca = new JLabel("Fecha:");
		lblMarca.setBounds(189, 11, 65, 22);
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblMarca);
		
		lblPrecio = new JLabel("Hora:");
		lblPrecio.setBounds(261, 11, 65, 22);
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblPrecio);
		
		lblPotencia = new JLabel("Precio:");
		lblPotencia.setBounds(336, 11, 77, 22);
		lblPotencia.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblPotencia);
		
		lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(423, 11, 97, 22);
		lblDescripcin.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblDescripcin);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCodigo.setBounds(10, 36, 65, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTipo.setBounds(86, 36, 79, 20);
		txtTipo.setColumns(10);
		contentPane.add(txtTipo);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFecha.setBounds(175, 36, 65, 20);
		txtFecha.setColumns(10);
		contentPane.add(txtFecha);
		
		txtHora = new JTextField();
		txtHora.setFont(new Font("Arial", Font.PLAIN, 12));
		txtHora.setBounds(250, 36, 76, 20);
		txtHora.setColumns(10);
		contentPane.add(txtHora);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPrecio.setBounds(336, 36, 77, 20);
		txtPrecio.setColumns(10);
		contentPane.add(txtPrecio);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDescripcion.setBounds(423, 36, 230, 20);
		txtDescripcion.setColumns(10);
		contentPane.add(txtDescripcion);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 90, 102, 23);
		btnAdicionar.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(10, 135, 102, 23);
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(10, 181, 102, 23);
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(10, 226, 102, 23);
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btnEliminar);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(this);
		btnImprimir.setBounds(10, 443, 102, 23);
		btnImprimir.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btnImprimir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 67, 685, 411);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFont(new Font("Consolas", Font.BOLD, 14));
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		//Modelo
		modelo = new DefaultTableModel(); 
		modelo.addColumn("Código"); 
		modelo.addColumn("Tipo Servicio"); 
		modelo.addColumn("Fecha"); 
		modelo.addColumn("Hora"); 
		modelo.addColumn("Precio"); 
		modelo.addColumn("Descripcion");
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LimpiarControles();
				Listar(aa);
				
			}
		});
		btnListar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListar.setBounds(10, 267, 102, 23);
		contentPane.add(btnListar);
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
		
		imprimirRepuestos();
		
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		// Adicionar :
        // adiciona un nuevo alumno verificando que el código no se repita.
        int cod = Integer.parseInt(txtCodigo.getText());
        String tip = txtTipo.getText().toString();
        String fec = txtFecha.getText().toString();
        String hor = txtHora.getText().toString();
        Double pre = Double.parseDouble(txtPrecio.getText());
        String des = txtDescripcion.getText().toString();
        
        // buscando el codigo si existe o no.
        Servicio resultado = aa.buscar(cod);
        if (resultado == null) {
            aa.adicionar(new Servicio(cod, tip, fec, hor, pre, des));
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
        Servicio Resultado = aa.buscar(cod);
        int pos = aa.buscarPosicion(cod);
        if (Resultado != null) {
            txtCodigo.setText(Integer.toString(aa.obtener(pos).getCodigo()));
            txtTipo.setText(aa.obtener(pos).getTipo());
            txtFecha.setText(aa.obtener(pos).getFecha());
            txtHora.setText(aa.obtener(pos).getHora());
            txtPrecio.setText(Double.toString(aa.obtener(pos).getPrecio()));
            txtDescripcion.setText(aa.obtener(pos).getDescripcion());
            
            
            // En la tabla
            cod = aa.obtener(pos).getCodigo();
            String tip = aa.obtener(pos).getTipo();
            String fec = aa.obtener(pos).getFecha();
            String hor = aa.obtener(pos).getHora();
            double pre = aa.obtener(pos).getPrecio();;
            String des = aa.obtener(pos).getDescripcion();
            modelo.setRowCount(0);
            Object[] fila = { cod, tip, fec, hor, pre, des};
            modelo.addRow(fila);
            tblTabla.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(null, "Registro no Encontrado");
            LimpiarControles();
        }
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int cod =Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo"));
        Servicio Resultado = aa.buscar(cod);
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
        Servicio Resultado = aa.buscar(cod);
        int pos = aa.buscarPosicion(cod);
        if (Resultado != null) {
            cod = Integer.parseInt(txtCodigo.getText());
            String tip = txtTipo.getText().toString();
            String fec = txtFecha.getText().toString();
            String hor = txtHora.getText().toString();
            Double pre = Double.parseDouble(txtPrecio.getText());
            String des = txtDescripcion.getText().toString();
            Resultado.setCodigo(cod);
            Resultado.setTipo(tip);
            Resultado.setFecha(fec);
            Resultado.setHora(hor);
            Resultado.setPrecio(pre);
            Resultado.setDescripcion(des);
            aa.modificar(pos, Resultado);
            Listar(aa);
            LimpiarControles();
        } else {
            JOptionPane.showMessageDialog(null, "Registro no Encontrado");
            LimpiarControles();
        }        
	}
	
	private void imprimirRepuestos() {
    	fp.exportarTablaEnFormatoCSV(modelo, this);
	}
}
