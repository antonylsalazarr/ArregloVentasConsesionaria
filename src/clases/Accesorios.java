package clases;

public class Accesorios {
	private int codigo, precio,unidades;
	private String nombre, marca ;
	
	public Accesorios(int codigo, String nombre, String marca , int precio ,int unidades) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.marca=marca;
		this.precio=precio;
		this.unidades=unidades;
	}
	
	public String estado() {
		if(unidades >0)
			return "Disponible";
		else
			return "Fuera de stock";
	}
//getters and setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	
	
	
	
}
