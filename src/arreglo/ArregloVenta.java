package arreglo;

import java.util.ArrayList;
import clases.Venta;

public class ArregloVenta {
	
	private ArrayList<Venta> ven;
	
	public ArregloVenta() {
		ven = new ArrayList<Venta>();
		ven.add(new Venta(100, "Sedán","Toyota", 25.000,"203 hp","El Toyota Camry es conocido por su confiabilidad y confort."));
		ven.add(new Venta(200, "SUV","Honda", 32.000,"280 hp","El Honda CR-V es un SUV compacto con amplio espacio interior y eficiencia en el consumo de combustible."));
		ven.add(new Venta(300, "Deportivo","Porsche", 120.000,"443 hp","El Porsche 911 es un auto deportivo icónico con excelente desempeño y manejo."));
		ven.add(new Venta(400, "Eléctrico","Tesla", 50.000,"346 hp","El Tesla Model 3 es un sedán eléctrico con tecnología avanzada y gran autonomía."));
		ven.add(new Venta(500, "Pickup","Ford", 35.000,"290 hp","La Ford F-150 es una camioneta robusta, ideal para el trabajo pesado y aventuras al aire libre."));
		ven.add(new Venta(600, "Hatchback","Volkswagen", 24.000,"228 hp","El Volkswagen Golf GTI combina un diseño compacto con un rendimiento deportivo."));
		ven.add(new Venta(700, "Minivan","Chrysler", 34.000,"287 hp","La Chrysler Pacifica es una minivan versátil y cómoda, ideal para familias."));
		ven.add(new Venta(800, "Convertible","BMW", 55.000,"255 hp","El BMW Z4 es un convertible elegante con una experiencia de conducción emocionante."));
		ven.add(new Venta(900, "Crossover","Subaru", 28.000,"182 hp","El Subaru Crosstrek es un crossover compacto con tracción en las cuatro ruedas y gran capacidad todoterreno."));
		ven.add(new Venta(1000, "Lujo","Mercedes-Benz", 90.000,"362 hp","El Mercedes-Benz E-Class es un sedán de lujo con tecnología avanzada y un interior refinado."));
	}
	
	public void adicionar(Venta x) {
		ven.add(x);
	}
	
	public int tamaño() {
		return ven.size();
	}
	
	public Venta obtener(int i) {
		return ven.get(i);
	}
	
	public Venta buscar(int codigo) {
		for(int i=0; i<tamaño(); i++)
			if(obtener(i).getCodigo()== codigo)
				return obtener(i);
		return null;		
	}
	
	public void eliminar(Venta x) {
		ven.remove(x);
	}
	
	public void modificar(int pos, Venta x) {
        ven.set(pos, x);
    }
	
	public int buscarPosicion(int cod) {
        for (int i=0; i<tamaño(); i++) 
            if (obtener(i).getCodigo() == cod) 
                return i; 
        return -1; 
    }
	

}
