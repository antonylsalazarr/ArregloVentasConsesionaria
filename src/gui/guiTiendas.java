package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import clases.Tiendas;
import funciones.Concesionario_FuncionesPublicas;
import arreglo.ArregloTiendas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guiTiendas extends JFrame {
	
	private DefaultTableModel modelo;
	
	ArregloTiendas ti = new ArregloTiendas();
	Concesionario_FuncionesPublicas fp = new Concesionario_FuncionesPublicas();
	
	void limpieza() {
        txtCodigo.setText("");
        txtDpto.setText("");
        txtProvincia.setText("");
        txtDistrito.setText("");
        txtCodigo.requestFocus();
    }   
    void listar() {
        modelo.setRowCount(0);
        for (int i=0; i<ti.tamanio(); i++) {
            Object[] fila = {ti.obtener(i).getCodigo(),
                             ti.obtener(i).getDepartamento(),
                             ti.obtener(i).getProvincia(),
                             ti.obtener(i).getDistrito(),
            				 ti.obtener(i).getNempleados()};
            modelo.addRow(fila);
        }
        tblTiendas.setModel(modelo);
    }

    //  Métodos tipo void (con parámetros)
    void mensaje(String s) {
        JOptionPane.showMessageDialog(this, s);
    }
    
    void error(String s, JTextField txt) {
        mensaje(s);
        txt.setText("");
        txt.requestFocus();
    }
    
    //  Métodos que retornan valor (sin parámetros)
    int leerCodigo() {
        return Integer.parseInt(txtCodigo.getText().trim());
    }
    
    String leerDepartamento() {
        return txtDpto.getText().trim();
    }
    
    String leerProvincia() {
        return txtProvincia.getText().trim();
    }
    
    String leerDistrito() {
        return txtDistrito.getText().trim();
    }
    
    int leerNempleados() {
        return Integer.parseInt(txtNempleados.getText());
    }

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDpto;
	private JTextField txtProvincia;
	private JTextField txtDistrito;
	private JTable tblTiendas;
	private JTextField txtNempleados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiTiendas frame = new guiTiendas();
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
	public guiTiendas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 789, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setTitle("Tiendas");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    int codigo = leerCodigo();
				    if (ti.buscar(codigo) == null) {
				        String dpto = leerDepartamento();
				        if (dpto.length() > 0) {
				            String provincia = leerProvincia();
				            if (provincia.length() > 0) {
				                String distrito = leerDistrito();
				                if (distrito.length() > 0) {
				                	int nempleados = leerNempleados();
				                	if (nempleados > 0) {
				                    Tiendas nuevo = new Tiendas(codigo, dpto, provincia, distrito, nempleados);
				                    ti.adicionar(nuevo);
				                    listar();
				                    limpieza();
				                	} else {
				    				    error("N° de Empleados no puede ser 0", txtNempleados);
				    				}
				                } else {
				                    error("ingrese DISTRITO", txtDistrito);
				                }
				            } else {
				                error("ingrese PROVINCIA", txtProvincia);
				            }
				        } else {
				            error("ingrese DEPARTAMENTO", txtDpto);
				        }
				        }
				} catch (NumberFormatException a) {
				    error("El código ya existe", txtCodigo);
				} catch (Exception b) {
				    error("Debe ingresar un código", null);
				}
			}
		});
		btnAdicionar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAdicionar.setBounds(10, 91, 102, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Código"));
                    Tiendas c = ti.buscar(codigo);
                    if (c == null) {
                        mensaje("el CÓDIGO no existe");
                        limpieza();
                    }
                    else {
                    	txtCodigo.setText("" + c.getCodigo());
                        txtDpto.setText(c.getDepartamento());
                        txtProvincia.setText("" + c.getProvincia());
                        txtDistrito.setText("" + c.getDistrito());
                        txtCodigo.requestFocus();
                    }
                }
                catch (Exception a) {
                    mensaje("ingrese CÓDIGO");
                    limpieza();
                }
				
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsultar.setBounds(10, 136, 102, 23);
		contentPane.add(btnConsultar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    int codigo = leerCodigo();
				    Tiendas x = ti.buscar(codigo);
				    if (x != null) {
				        String dpto = leerDepartamento();
				        if (dpto.length() > 0) {
				            String provincia = leerProvincia();
				            if (provincia.length() > 0) {
				                String distrito = leerDistrito();
				                if (distrito.length() > 0) {
				                    try {
				                        int nempleados = leerNempleados();
				                        if (nempleados > 0) {
				                            x.setCodigo(codigo);
				                            x.setDepartamento(dpto);
				                            x.setProvincia(provincia);
				                            x.setDistrito(distrito);
				                            x.setNempleados(nempleados);
				                            ti.actualizarArchivo();
				                            listar();
				                            limpieza();
				                        } else {
				                            error("N° de Empleados no puede ser 0", txtNempleados);
				                        }
				                    } catch (NumberFormatException a) {
				                        error("Número de empleados inválido", txtNempleados);
				                    }
				                } else {
				                    error("Ingrese DISTRITO", txtDistrito);
				                }
				            } else {
				                error("Ingrese PROVINCIA", txtProvincia);
				            }
				        } else {
				        	error("Ingrese DEPARTAMENTO", txtDpto);
				        }
				    } else {
				        error("El código no existe", txtCodigo);
				    }
				} catch (NumberFormatException b) {
				    error("El código ya existe", txtCodigo);
				} catch (Exception c) {
				    error("El código no puede estar vacío", null);
				}
			}
		});
		btnModificar.setFont(new Font("Arial", Font.BOLD, 14));
		btnModificar.setBounds(10, 182, 102, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
                	int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Código"));
                    Tiendas c = ti.buscar(codigo);
                    if (c == null)
                        mensaje("el CÓDIGO no existe");
                    else {
                        ti.eliminar(c);
                        listar();
                    }
                    limpieza();
                }
                catch (Exception c) {
                    error("ingrese CÓDIGO", txtCodigo);
                }
				
			}
		});
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 14));
		btnEliminar.setBounds(10, 227, 102, 23);
		contentPane.add(btnEliminar);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				imprimirRepuestos();
				
			}
		});
		btnImprimir.setFont(new Font("Arial", Font.BOLD, 14));
		btnImprimir.setBounds(10, 301, 102, 23);
		contentPane.add(btnImprimir);
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 64, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Departamento:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(103, 10, 134, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Provincia:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(284, 9, 115, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Distrito:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(462, 10, 94, 13);
		contentPane.add(lblNewLabel_3);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCodigo.setBounds(10, 33, 71, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDpto = new JTextField();
		txtDpto.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDpto.setBounds(103, 33, 157, 19);
		contentPane.add(txtDpto);
		txtDpto.setColumns(10);
		
		txtProvincia = new JTextField();
		txtProvincia.setFont(new Font("Arial", Font.PLAIN, 12));
		txtProvincia.setBounds(284, 33, 157, 19);
		contentPane.add(txtProvincia);
		txtProvincia.setColumns(10);
		
		txtDistrito = new JTextField();
		txtDistrito.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDistrito.setColumns(10);
		txtDistrito.setBounds(462, 33, 157, 19);
		contentPane.add(txtDistrito);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(136, 75, 629, 379);
		contentPane.add(scrollPane);
		
		tblTiendas = new JTable();
		tblTiendas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTiendas);
		
		modelo = new DefaultTableModel();
		 modelo.addColumn("Código");
		 modelo.addColumn("Departamento");
		 modelo.addColumn("Provincia");
		 modelo.addColumn("Distrito");
		 modelo.addColumn("Número de Empleados");
		 tblTiendas.setModel(modelo);
		 
		 JLabel lblNewLabel_3_1 = new JLabel("N° Empleados:");
		 lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 14));
		 lblNewLabel_3_1.setBounds(642, 10, 123, 13);
		 contentPane.add(lblNewLabel_3_1);
		 
		 txtNempleados = new JTextField();
		 txtNempleados.setFont(new Font("Arial", Font.PLAIN, 12));
		 txtNempleados.setColumns(10);
		 txtNempleados.setBounds(642, 33, 49, 19);
		 contentPane.add(txtNempleados);
		 listar();
	}
		 
		 private void imprimirRepuestos() {
		    	fp.exportarTablaEnFormatoCSV(modelo, this);
		 
	}
}
