package clases;

public class Vehiculos {
	//con los atributos privados: código, nombre, nota1 y nota2; un
		//constructor, los métodos de acceso público set/ get y el método promedio.
		
		//Atributos
		private int codigo;
		private double precio;
		private String tipo, marca,potencia, descripcion;
		
		public Vehiculos(int codigo, String tipo, String marca, double precio, String potencia, String descripcion) {
			this.codigo= codigo;
			this.tipo= tipo;
			this.marca= marca;
			this.precio= precio;
			this.potencia= potencia;
			this.descripcion= descripcion;
		}

		// Metodo de Acceso publico set - get
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

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getPotencia() {
			return potencia;
		}

		public void setPotencia(String potencia) {
			this.potencia = potencia;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		
		
}
