package gui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JOptionPane;

import clases.Repuestos;
import arreglo.ArregloRepuestos;
import funciones.Concesionario_FuncionesPublicas;
import java.awt.Font;

public class guiRepuestos extends JFrame {
    
	private JTextField txtCodigo, txtNombre, txtPrecio, txtCantidad;
    private JTable table;
    private DefaultTableModel model;
    private JComboBox comboBoxEstado;
    private ArregloRepuestos ArregloRepuestos;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiRepuestos frame = new guiRepuestos();
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
	public guiRepuestos() {
		ArregloRepuestos = new ArregloRepuestos();
		
        setTitle("Repuestos");
        setSize(706, 449);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCodigoRepuesto = new JLabel("<html>Código:");
        lblCodigoRepuesto.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCodigoRepuesto.setHorizontalAlignment(SwingConstants.LEFT);
        lblCodigoRepuesto.setBounds(19, 26, 80, 25);
        getContentPane().add(lblCodigoRepuesto);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(74, 28, 80, 25);
        getContentPane().add(txtCodigo);

        JLabel lblNombreRepuesto = new JLabel("Nombre del Repuesto:");
        lblNombreRepuesto.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNombreRepuesto.setBounds(190, 26, 145, 25);
        getContentPane().add(lblNombreRepuesto);

        txtNombre = new JTextField();
        txtNombre.setBounds(334, 26, 353, 25);
        getContentPane().add(txtNombre);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPrecio.setBounds(452, 61, 51, 25);
        getContentPane().add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(513, 61, 71, 25);
        getContentPane().add(txtPrecio);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCantidad.setBounds(19, 62, 80, 25);
        getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(89, 61, 65, 25);
        getContentPane().add(txtCantidad);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnAdicionar.setBounds(19, 129, 100, 25);
        getContentPane().add(btnAdicionar);

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnConsultar.setBounds(19, 174, 100, 25);
        getContentPane().add(btnConsultar);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnModificar.setBounds(19, 220, 100, 25);
        getContentPane().add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnEliminar.setBounds(19, 264, 100, 25);
        getContentPane().add(btnEliminar);

        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.setFont(new Font("Arial", Font.PLAIN, 14));
        btnImprimir.setBounds(19, 354, 100, 25);
        getContentPane().add(btnImprimir);

        String[] columnNames = {"Codigo", "Nombre", "Precio", "Cantidad", "Valor Total", "Estado"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable(model);
        table.setFont(new Font("Consolas", Font.BOLD, 14));
        table.getTableHeader().setReorderingAllowed(false);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(130, 119, 539, 260);
        getContentPane().add(scrollPane);
        
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setFont(new Font("Arial", Font.PLAIN, 14));
        lblEstado.setBounds(200, 61, 60, 25);
        getContentPane().add(lblEstado);
        
        comboBoxEstado = new JComboBox();
        comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"", "En Preparacion", "Disponible"}));
        comboBoxEstado.setBounds(265, 62, 132, 22);
        getContentPane().add(comboBoxEstado);

        // Funciones_de_los_botones
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarRepuesto();
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarRepuesto();
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarRepuesto();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarRepuesto();
            }
        });

        btnImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimirRepuestos();
            }
        });
    }

    private void adicionarRepuesto() {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());
        String estado = (String) comboBoxEstado.getSelectedItem();

        Repuestos repuesto = new Repuestos(codigo, nombre, precio, cantidad, estado);
        ArregloRepuestos.adicionarRepuesto(repuesto);
        model.addRow(repuesto.toRow());

        limpiarCampos();
    }

    private void consultarRepuesto() {
        String codigo = txtCodigo.getText();
        Repuestos repuesto = ArregloRepuestos.consultarRepuesto(codigo);
        if (repuesto != null) {
            txtNombre.setText(repuesto.getNombre());
            txtPrecio.setText(String.valueOf(repuesto.getPrecio()));
            txtCantidad.setText(String.valueOf(repuesto.getCantidad()));
            comboBoxEstado.setSelectedItem(repuesto.getEstado());
        } else {
        	JOptionPane.showMessageDialog(this, "Registro no encontrado", "Log de Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void modificarRepuesto() {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());
        String estado = (String) comboBoxEstado.getSelectedItem();

        Repuestos repuestoModificado = new Repuestos(codigo, nombre, precio, cantidad, estado);
        ArregloRepuestos.modificarRepuesto(repuestoModificado);

        // Actualizar_la_tabla
        actualizarTabla();
        limpiarCampos();
    }

    private void eliminarRepuesto() {
        String codigo = txtCodigo.getText();
        ArregloRepuestos.eliminarRepuesto(codigo);

        // Actualizar_la_tabla
        actualizarTabla();
        limpiarCampos();
    }

    private void imprimirRepuestos() {
    	Concesionario_FuncionesPublicas.exportarTablaEnFormatoCSV(model, this);
    }

    private void actualizarTabla() {
        model.setRowCount(0); // Restablecer_Filas
        for (Repuestos repuesto : ArregloRepuestos.obtenerTodosRepuestos()) {
            model.addRow(repuesto.toRow());
        }
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        comboBoxEstado.setSelectedItem("");
    }
}