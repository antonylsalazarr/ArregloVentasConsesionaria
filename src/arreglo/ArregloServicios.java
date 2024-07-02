package arreglo;

import java.util.ArrayList;
import clases.Servicio;


public class ArregloServicios {

private ArrayList<Servicio> ser;
	
	public ArregloServicios() {
		ser = new ArrayList<Servicio>();
		ser.add(new Servicio(100, "Mantenimiento general","12/07/2024", "15:45 pm",450,"Auto no enciende"));
		ser.add(new Servicio(200, "Revisión electrica","17/07/2024", "14:55 pm",150,"Bateria se descarga frecuentemente"));
		ser.add(new Servicio(300, "Planchado","19/07/2024", "18:45 pm",650,"Pintura de auto desgastada"));
		ser.add(new Servicio(400, "Cambio de aceite","11/07/2024", "13:45 pm",50,"Aceite en mal estado"));
		ser.add(new Servicio(500, "Cambio de bujia","12/07/2024", "14:35 pm",75,"Bujia quemada"));
		ser.add(new Servicio(600, "Tapicería","13/07/2024", "09:00 am",400,"Tapiceria interior rota"));
		ser.add(new Servicio(700, "Mantenimiento general","12/07/2024", "15:45 pm",450,"Auto no enciende"));
		ser.add(new Servicio(800, "Mantenimiento general","19/07/2024", "15:45 pm",450,"Auto no enciende"));
		ser.add(new Servicio(900, "Mantenimiento general","20/07/2024", "15:45 pm",450,"Auto no enciende"));
		ser.add(new Servicio(101, "Mantenimiento general","25/07/2024", "15:45 pm",450,"Auto no enciende"));
	}
	
	public void adicionar(Servicio x) {
		ser.add(x);
	}
	
	public int tamaño() {
		return ser.size();
	}
	
	public Servicio obtener(int i) {
		return ser.get(i);
	}
	
	public Servicio buscar(int codigo) {
		for(int i=0; i<tamaño(); i++)
			if(obtener(i).getCodigo()== codigo)
				return obtener(i);
		return null;		
	}
	
	public void eliminar(Servicio x) {
		ser.remove(x);
	}
	
	public void modificar(int pos, Servicio x) {
        ser.set(pos, x);
    }
	
	public int buscarPosicion(int cod) {
        for (int i=0; i<tamaño(); i++) 
            if (obtener(i).getCodigo() == cod) 
                return i; 
        return -1; 
    }
	
	
	
	
}
