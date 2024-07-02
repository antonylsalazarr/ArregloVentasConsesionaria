package clases;

public class Servicio {

	//con los atributos privados: código, nombre, nota1 y nota2; un
	//constructor, los métodos de acceso público set/ get y el método promedio.
	
	//Atributos
	private int codigo;
	private double precio;
	private String tipo, fecha, hora, descripcion;
	
	public Servicio(int codigo, String tipo, String fecha, String hora, double precio, String descripcion) {
		this.codigo= codigo;
		this.tipo= tipo;
		this.fecha= fecha;
		this.hora= hora;
		this.precio= precio;
		this.descripcion= descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
