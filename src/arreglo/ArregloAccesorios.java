package arreglo;

import java.util.ArrayList;

import clases.Accesorios;

public class ArregloAccesorios {
	
	private ArrayList<Accesorios> acc;
	
	public ArregloAccesorios() {
		acc= new ArrayList<Accesorios>();
		acc.add(new Accesorios(145, "Filtro de Aire", "Bosch", 150, 25   ));
		acc.add(new Accesorios(458, "Batería", "Exide", 200, 15   ));
		acc.add(new Accesorios(134, "Neumático", "Michelin", 120, 0   ));
		acc.add(new Accesorios(987, "Aceite de Motor", "Castrol", 80, 50   ));
		acc.add(new Accesorios(356, "Lámpara LED", "Philips", 45, 0   ));
		acc.add(new Accesorios(765, "Espejo Retrovisor", "CIPA", 60, 20   ));
		acc.add(new Accesorios(834, "Cargador de Batería", "Schumacher", 100, 10  ));
		acc.add(new Accesorios(347, "Funda para Asientos", "FH Group", 85, 35   ));
		acc.add(new Accesorios(119, "GPS", "Garmin", 250, 5   ));
			
	}
		
	public void adicionar(Accesorios x) {
		acc.add(x);
	} 
	
	public int tamano() {
		return acc.size();
	}

	public Accesorios obtener(int i) {
		return acc.get(i);
	}
	
	public Accesorios buscar(int codigo) {
		for(int i=0;i<tamano();i++)
			if( obtener(i).getCodigo() == codigo )
				return obtener(i);
		return null;
	}
	
	public void eliminar(Accesorios x) {
		acc.remove(x);
	}
	public void modificar(int pos,Accesorios x) {
		acc.set(pos, x);
	}
	
	public int buscarPosicion(int cod) {
		for(int i=0;i<tamano();i++)
			if(obtener(i).getCodigo() == cod)
				return i;
		return -1;
		
	}
	
	
	
	
}
