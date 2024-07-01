package arreglo;

import clases.Tiendas;
import java.io.*;
import java.util.ArrayList;

public class ArregloTiendas {
	
//  Atributo privado
    private ArrayList <Tiendas> ti;
    
    //  Constructor
    public ArregloTiendas() {
        ti = new ArrayList <Tiendas> ();
        cargarTiendas(); // Carga al arraylist con los datos del archivo txt
    }
    
    //  Operaciones públicas básicas
    public void adicionar(Tiendas x) {
        ti.add(x);
        grabarTiendas();
    }
    
    public int tamanio() {
        return ti.size();
    }
    
    public Tiendas obtener(int i) {
        return ti.get(i);
    }
    
    public Tiendas buscar(int codigo) {
        for (int i=0; i<tamanio(); i++)
            if (obtener(i).getCodigo() == codigo)
                return obtener(i);
        return null;
    }
    
    public void eliminar(Tiendas x) {
        ti.remove(x);
        grabarTiendas();
    }
    
    public void actualizarArchivo() {
        grabarTiendas();
    }
    
    private void grabarTiendas() {
        try {
            PrintWriter pw;
            String linea;
            Tiendas x;
            pw = new PrintWriter(new FileWriter("tiendas.txt"));
            for (int i=0; i<tamanio(); i++) {
                x = obtener(i);
                linea = x.getCodigo() + ";" +
                        x.getDepartamento() + ";" +
                        x.getProvincia() + ";" +
                        x.getDistrito();
                		x.getNempleados();
                pw.println(linea);
            }
            pw.close();
        }
        catch (Exception e) {
        }
    }
    
    private void cargarTiendas() {
        try {
            BufferedReader br;
            String linea, departamento, provincia, distrito;
            String[] s;
            int codigo, nempleados;
            br = new BufferedReader(new FileReader("tiendas.txt"));
            while ((linea = br.readLine()) != null) {
                s = linea.split(";");
                codigo = Integer.parseInt(s[0].trim());
                distrito = s[1].trim();
                departamento = String.valueOf(s[2].trim());
                provincia = String.valueOf(s[3].trim());
                nempleados = Integer.parseInt(s[0].trim());
                adicionar(new Tiendas(codigo, departamento, provincia, distrito, nempleados));
            }
            br.close();
        }
        catch (Exception e) {
        }
    }

}
